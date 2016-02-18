import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PlayerTest {

  @Test
  public void player_initializesCorrectly() {
    Player newPlayer = new Player();
    assertEquals(true, newPlayer instanceof Player);
  }
}
