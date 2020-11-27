package number;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PlayerNumberTest {

    @Test
    public void create(){

        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PlayerNumber playerNumber = new PlayerNumber();

        assertEquals("123", playerNumber.getInputNumber());

    }

}