package baseball.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void playerInputValueTestInvalidWithLongerInput(){
        String data = "1235";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Player player = new Player(new Scanner(System.in));
        assertThrows(IllegalArgumentException.class, ()->
                player.getInputValue());
    }

    @Test
    public void playerInputValueTestInvalidWithShorterInput(){
        String data = "12";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Player player = new Player(new Scanner(System.in));
        assertThrows(IllegalArgumentException.class, ()->
                player.getInputValue());
    }

    @Test
    public void playerInputValueTestInvalidWithCharacterInput(){
        String data = "abe";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Player player = new Player(new Scanner(System.in));
        assertThrows(IllegalArgumentException.class, ()->
                player.getInputValue());
    }

    @Test
    public void playerInputValueTestValid(){
        String data = "123";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Player player = new Player(new Scanner(System.in));
        assertDoesNotThrow(()-> player.getInputValue());
    }
}