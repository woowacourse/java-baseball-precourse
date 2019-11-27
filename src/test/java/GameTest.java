import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testInit(){
        Game game = new Game();
        assertThat(game).isNotNull();
    }

    @Test
    public void testRandomGenerator(){
        Game game = new Game();
        assertThat(Arrays.stream(game.getComputerNumbers())
                .allMatch(x -> (x >= 1 && x <= 9))
        ).isTrue();
    }

}