package baseball;

import baseball.Application.GameStatus;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationUnitTest {

    private static InputStream originIn;

    @BeforeAll
    public static void setUp() {
        originIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originIn);
    }

    @Test
    public void testGenerateAnswer() throws Error {
        for(int i = 0; i < 1000; i++) {
            int answer = Application.generateAnswer();
            assertEquals(true, answer > 0);
            assertEquals(true, answer < 1000);
        }
    }

    @Test
    public void testPlayBaseball() throws Error {
        int answer = 345;
        Scanner scanner = new Scanner(System.in);
        String input = "345";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertDoesNotThrow(() -> Application.playBaseball(answer, scanner));

        input = "-1";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(IllegalArgumentException.class,
            () -> Application.playBaseball(answer, scanner));
    }

    @Test
    public void testDecideNext() throws Error {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        final Scanner finalScanner = new Scanner(in);
        assertThrows(IllegalArgumentException.class, () -> Application.decideNext(finalScanner));

        input = "1";
        in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        assertEquals(GameStatus.play, Application.decideNext(scanner));

        input = "2";
        in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
        assertEquals(GameStatus.quit, Application.decideNext(scanner));
    }

    @Test
    public void testCheckAnswer() {
        Hint result = Application.checkAnswer("123", "123");
        assertEquals(3, result.getStrike());
        assertEquals(0, result.getBall());

        result = Application.checkAnswer("123", "132");
        assertEquals(1, result.getStrike());
        assertEquals(2, result.getBall());

        result = Application.checkAnswer("123", "456");
        assertEquals(0, result.getStrike());
        assertEquals(0, result.getBall());
    }
}
