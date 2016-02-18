import java.util.*;

public class Player {
  private static ArrayList<Card> mHand;

  public Player() {
    mHand = new ArrayList<Card>();
  }

  public ArrayList<Card> getHand() {
    return mHand;
  }

  public boolean legalGuess(String guess){
    for (Card card : mHand){
      if (card.getValue().equals(guess)){
        return true;
      }
    }
    return false;
  }
}
