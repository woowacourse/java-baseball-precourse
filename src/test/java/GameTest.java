import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testInit(){
        Game game = new Game();
        assertThat(game).isNotNull();
    }
}