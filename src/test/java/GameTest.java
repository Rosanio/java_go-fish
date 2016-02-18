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

}




//Get Hand of 7 Cards -- ArrayList of random cards
