import java.util.*;

public class Player {
  private static ArrayList<Card> mHand;

  public Player() {
    mHand = new ArrayList<Card>();
  }

  public ArrayList<Card> getHand() {
    return mHand;
  }
}
