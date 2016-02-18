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

}
