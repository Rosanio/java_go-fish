import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PlayerTest {

  @Test
  public void player_initializesCorrectly() {
    Player newPlayer = new Player();
    assertEquals(true, newPlayer instanceof Player);
  }

  @Test
  public void legalGuess_comparesGuessToPlayersHandToProceed(){
    Player testPlayer = new Player();
    Card testCard = new Card("Spades", "Ace");
    testPlayer.getHand().add(testCard);
    assertEquals(true, testPlayer.legalGuess("Ace"));
  }

  @Test
  public void checkForBook_checksPlayerHandForBook() {
    Player testPlayer = new Player();
    Card testCard = new Card("Spades", "Ace");
    Card testCard2 = new Card("Diamonds", "Ace");
    Card testCard4 = new Card("Hearts", "Ace");
    Card testCard3 = new Card("Clubs", "Ace");
    testPlayer.checkForBook();
    assertEquals(0, testPlayer.getHand().size());
  }

  @Test
  public void goFish_drawsCardIfPlayerGuessesWrong() {
    Player testPlayer = new Player();
    Card testCard = new Card("Spades", "Ace");
    Card testCard2 = new Card("Diamonds", "Ace");
    Card testCard4 = new Card("Hearts", "Ace");
    Card testCard3 = new Card("Clubs", "Ace");
    testPlayer.checkForBook();
    assertEquals(0, testPlayer.getHand().size());
  }

}
