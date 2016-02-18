import java.util.*;


public class Deck {
  private static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private static final String[] VALUES = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
  ArrayList<Card> cards = new ArrayList<Card>();

  public void makeCards() {

    for(String suit: SUITS) {
      for(String value: VALUES) {
        Card tempCard = new Card(suit, value);
        cards.add(tempCard);
      }
    }
  }

  public ArrayList getCards() {
    return cards;
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }
}
