package baseball;

import baseball.Application.GameStatus;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationUnitTest {

    @Test
    public void testGenerateAnswer() throws Error {
        for (int i = 0; i < 1000; i++) {
            int answer = Application.generateAnswer();
            assertEquals(true, answer > 0);
            assertEquals(true, answer < 1000);
        }
    }

    @Test
    public void testPlayBaseball() throws Error {
        int answer = 345;

        String input = "345";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner1 = new Scanner(in);
        assertDoesNotThrow(() -> Application.playBaseball(answer, scanner1));

        input = "-1";
        in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner2 = new Scanner(in);
        assertThrows(IllegalArgumentException.class,
            () -> Application.playBaseball(answer, scanner2));
    }

    @Test
    public void testIsCorrect() throws Error {
        assertEquals(true, Application.isCorrect(new Hint(3, 0)));
        assertEquals(false, Application.isCorrect(new Hint(2, 0)));
    }

    @Test
    public void testToStringAnswer() throws Error {
        assertEquals("456", Application.toStringAnswer(456));
        assertEquals("012", Application.toStringAnswer(12));
    }

    @Test
    public void testIsHeadZeroOmitted() throws Error {
        assertEquals(true, Application.isHeadZeroOmitted("45"));
        assertEquals(false, Application.isHeadZeroOmitted("345"));
    }

    @Test
    public void testIsSubmittedAnswerValid() throws Error {
        assertEquals(true, Application.isSubmittedAnswerValid("456"));
        assertEquals(false, Application.isSubmittedAnswerValid("12"));
        assertEquals(false, Application.isSubmittedAnswerValid("abc"));
    }

    @Test
    public void testDecideNext() throws Error {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner finalScanner = new Scanner(in);
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
    public void testCheckAnswer() throws Error {
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
