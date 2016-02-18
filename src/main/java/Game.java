import java.util.*;

public class Game {

  private Deck mGameDeck;
  private Player mPlayer1;
  private Player mPlayer2;
  private Player mCurrentPlayer;
  private Player mNotCurrentPlayer;

  public Game() {
    mGameDeck = new Deck();
    mPlayer1 = new Player();
    mPlayer2 = new Player();
    mGameDeck.makeCards();
    mGameDeck.shuffle();
    mCurrentPlayer = mPlayer1;
    mNotCurrentPlayer = mPlayer2;
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

  public Player getCurrentPlayer(){
    return mCurrentPlayer;
  }

  public Player getNotCurrentPlayer(){
    return mNotCurrentPlayer;
  }

  public void dealHand(Player player) {
    for(Integer i = 1; i <= 7; i++) {
      Card tempCard = mGameDeck.deal();
      player.getHand().add(tempCard);
    }
  }

  public void switchTurns() {
    if(mCurrentPlayer == mPlayer1) {
      mCurrentPlayer = mPlayer2;
      mNotCurrentPlayer = mPlayer1;
    } else {
      mCurrentPlayer = mPlayer1;
      mNotCurrentPlayer = mPlayer2;
    }
  }

  public String findMatch(String guess){
    ArrayList<Card> matchingCards = new ArrayList<Card>();
    Integer handSize = mCurrentPlayer.getHand().size();
    String result = "";
    if (mCurrentPlayer.legalGuess(guess)){
      for (Card card : mNotCurrentPlayer.getHand()){
        if (card.getValue().equals(guess)){
          matchingCards.add(card);
        }
      }
      for (Card card : matchingCards){
        mCurrentPlayer.getHand().add(card);
        mNotCurrentPlayer.getHand().remove(card);
      }
      if(mCurrentPlayer.getHand().size() == handSize) {
        result = "Go Fish";
      } else {
        result = "Guess Again";
      }
    } else {
      result = "Not a legal Guess";
    }
    return result;
  }

  public void goFish(String guess){
    Card fishCard = mGameDeck.deal();
    mCurrentPlayer.getHand().add(fishCard);
    if (!fishCard.getValue().equals(guess)){
      this.switchTurns();
    }
  }

}
