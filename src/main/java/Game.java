import java.util.*;

public class Game {

  private Deck mGameDeck;
  private Player mPlayer1;
  private Player mPlayer2;

  public Game() {
    mGameDeck = new Deck();
    mPlayer1 = new Player();
    mPlayer2 = new Player();
    mGameDeck.makeCards();
    mGameDeck.shuffle();
  }

  public Deck getDeck() {
    return mGameDeck;
  }

  public Player getPlayer1() {
    return mPlayer1;
  }

  public Player getPlayer2() {
    return mPlayer2;
  }

  public void dealHand(Player player) {
    for(Integer i = 1; i <= 7; i++) {
      Card tempCard = mGameDeck.deal();
      player.getHand().add(tempCard);
    }
  }

}
