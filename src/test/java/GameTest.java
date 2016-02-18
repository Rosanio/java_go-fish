import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class GameTest {

  @Test
  public void game_createsInstanceOfGame_true(){
    Game newGame = new Game();
    assertEquals(true, newGame instanceof Game);
  }


  @Test
  public void dealHand_givesPlayerRandomCardFromDeck(){
    Game newGame = new Game();
    newGame.dealHand(newGame.getPlayer1());
    assertEquals(7, newGame.getPlayer1().getHand().size());
  }

  @Test
  public void findMatch_takesMatchingCardGuessFromOppositePlayer(){
    Game newGame = new Game();
    Card cardOne = new Card("Hearts", "9");
    Card cardThree = new Card("Hearts", "8");
    Card cardFour = new Card("Spades", "9");
    Card cardTwo = new Card("Clubs", "9");
    newGame.getPlayer1().getHand().add(cardOne);
    newGame.getPlayer2().getHand().add(cardTwo);
    newGame.getPlayer2().getHand().add(cardThree);
    newGame.getPlayer2().getHand().add(cardFour);
    newGame.findMatch("9");
    assertTrue(newGame.getPlayer1().getHand().contains(cardTwo) && newGame.getPlayer1().getHand().contains(cardFour));
  }



}




//Get Hand of 7 Cards -- ArrayList of random cards
