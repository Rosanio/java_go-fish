import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if(process.environment().get("PORT") != null) {
      port = Integer.parseInt(process.environment().get("PORT"));
    } else {
      port = 4567;
    }

    setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Game newGame = new Game();
      newGame.dealHand(newGame.getPlayer1());
      newGame.dealHand(newGame.getPlayer2());
      request.session().attribute("game", newGame);
      model.put("template", "templates/NewGame.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/playerOneTurn", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Game oldGame = request.session().attribute("game");
      oldGame.getPlayer1().checkForBook();
      ArrayList<Card> playerOne = oldGame.getPlayer1().getHand();
      ArrayList<String> playerOneCardNames = new ArrayList<String>();
      for(Card card:playerOne) {
        playerOneCardNames.add(card.name());
      }
      String p1score = Integer.toString(oldGame.getPlayer1().getScore());
      String p2score = Integer.toString(oldGame.getPlayer2().getScore());

      model.put("p1score", p1score);
      model.put("p2score", p2score);
      model.put("playerOne", playerOneCardNames);
      model.put("template", "templates/PlayerOneTurn.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/playeroneresult", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Game oldGame = request.session().attribute("game");
      String guess = request.queryParams("guess");
      String result = oldGame.findMatch(guess);
      Integer p1Score = oldGame.getPlayer1().getScore();
      Integer p2Score = oldGame.getPlayer2().getScore();
      if(result == "Go Fish") {
        oldGame.goFish(guess);
        if(oldGame.getCurrentPlayer() == oldGame.getPlayer2()) {
          result = "Player 2 Turn";
        } else {
          result = "Guess Again";
        }
      }
      if(p1Score+p2Score == 13) {
        if(p1Score > p2Score) {
          result = "Player 1 Wins";
        } else {
          result = "Player 2 Wins";
        }
      }
      model.put("result", result);
      model.put("template", "templates/playerOneResult.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/playerTwoReady", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/PlayerTwoReady.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/playerTwoTurn", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Game oldGame = request.session().attribute("game");
      oldGame.getPlayer2().checkForBook();
      ArrayList<Card> playerTwo = oldGame.getPlayer2().getHand();
      ArrayList<String> playerTwoCardNames = new ArrayList<String>();
      for(Card card:playerTwo) {
        playerTwoCardNames.add(card.name());
      }
      String p1score = Integer.toString(oldGame.getPlayer1().getScore());
      String p2score = Integer.toString(oldGame.getPlayer2().getScore());

      model.put("p1score", p1score);
      model.put("p2score", p2score);
      model.put("playerTwo", playerTwoCardNames);
      model.put("template", "templates/PlayerTwoTurn.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/playerTwoResult", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Game oldGame = request.session().attribute("game");
      String guess = request.queryParams("guess");
      String result = oldGame.findMatch(guess);
      Integer p1Score = oldGame.getPlayer1().getScore();
      Integer p2Score = oldGame.getPlayer2().getScore();
      if(result == "Go Fish") {
        oldGame.goFish(guess);
        if(oldGame.getCurrentPlayer() == oldGame.getPlayer1()) {
          result = "Player 1 Turn";
        } else {
          result = "Guess Again";
        }
      }
      if(p1Score+p2Score == 13) {
        if(p1Score > p2Score) {
          result = "Player 1 Wins";
        } else {
          result = "Player 2 Wins";
        }
      }
      model.put("result", result);
      model.put("template", "templates/playerTwoResult.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());

    get("/playerOneReady", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/PlayerOneReady.vtl");
      return new ModelAndView (model, layout);
    }, new VelocityTemplateEngine());
  }
}
