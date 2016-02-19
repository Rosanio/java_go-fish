import java.util.*;

public class Player {
  private static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private static final String[] VALUES = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

  private ArrayList<Card> mHand;
  private Integer mScore;

  public Player() {
    mHand = new ArrayList<Card>();
    mScore = 0;
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

  public void checkForBook() {
    ArrayList<Card> duplicates;
    for(String value : VALUES) {
      duplicates = new ArrayList<Card>();
      for(Card handCard : mHand) {
        if(value.equals(handCard.getValue())) {
          duplicates.add(handCard);
        }
      }
      if(duplicates.size() == 4) {
        mScore += 1;
        for(Card dupCard: duplicates) {
          mHand.remove(dupCard);
        }
      }
    }
  }

  public Integer getScore() {
    return mScore;
  }

}
