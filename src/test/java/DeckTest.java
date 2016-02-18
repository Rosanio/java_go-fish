import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class DeckTest {

  @Test
  public void deck_initializesCorrectly() {
    Deck testDeck = new Deck();
    assertEquals(true, testDeck instanceof Deck);
  }

  @Test
  public void getCards_initializesWith52Cards_52() {
    Deck testDeck = new Deck();
    testDeck.makeCards();
    assertEquals(52, testDeck.getCards().size());
  }

  @Test
  public void getCards_cardsAreInitalizedWithSuitsAndValues_AceOfSpades() {
    Deck testDeck = new Deck();
    testDeck.makeCards();
    Card aceOfSpades = (Card)testDeck.getCards().get(0);
    assertEquals("Ace of Spades", aceOfSpades.name());
  }

  @Test
  public void getCards_deckContains52UniqueCards_kingOfDiamonds() {
    Deck testDeck = new Deck();
    testDeck.makeCards();
    Card kingOfDiamonds = (Card)testDeck.getCards().get(51);
    assertEquals("King of Diamonds", kingOfDiamonds.name());
  }

  @Test
  public void shuffle_deckContainsRandomlyOrderedCards_notAceOfSpades() {
    Deck testDeck = new Deck();
    testDeck.makeCards();
    testDeck.shuffle();
    Card aceOfSpades = (Card)testDeck.getCards().get(0);
    assertEquals("Ace of Spades", aceOfSpades.name());
  }
}
