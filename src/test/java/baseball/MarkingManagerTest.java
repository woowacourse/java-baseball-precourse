package baseball;

import baseball.exception.WrongGuessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MarkingManagerTest {
    private MarkingManager markingManager;
    private OutputStream out;

    @BeforeEach
    public void setup() {
        int[] answerArray = {1, 2, 3};
        markingManager = new MarkingManager(answerArray);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void 정답을맞추었을때_Test() throws WrongGuessException {
        int[] guessArray = {1, 2, 3};
        markingManager.mark(guessArray);
        Assertions.assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", out.toString());
    }

    @Test
    public void 낫싱Exception_Test() throws WrongGuessException {
        Assertions.assertThrows(WrongGuessException.class, () -> {
            int[] guessArray = {4, 5, 6};
            markingManager.mark(guessArray);
            Assertions.assertEquals("싱", out.toString());
        });
    }

    @Test
    public void 낫싱print_Test() throws WrongGuessException {
        try {
            int[] guessArray = {4, 5, 6};
            markingManager.mark(guessArray);
        } catch (WrongGuessException e) {
            Assertions.assertEquals("낫싱", out.toString());
        }
    }

    @Test
    public void 볼Exception_Test() throws WrongGuessException {
        Assertions.assertThrows(WrongGuessException.class, () -> {
            int[] guessArray = {3, 4, 5};
            markingManager.mark(guessArray);
        });
    }

    @Test
    public void 볼print_Test() throws WrongGuessException {
        try {
            int[] guessArray = {3, 4, 5};
            markingManager.mark(guessArray);
        } catch (WrongGuessException e) {
            Assertions.assertEquals("1볼", out.toString());
        }
    }

    @Test
    public void 스트라이크Exception_Test() throws WrongGuessException {
        Assertions.assertThrows(WrongGuessException.class, () -> {
            int[] guessArray = {5, 6, 3};
            markingManager.mark(guessArray);
        });
    }

    @Test
    public void 스트라이크print_Test() throws WrongGuessException {
        try {
            int[] guessArray = {1, 2, 5};
            markingManager.mark(guessArray);
        } catch (WrongGuessException e) {
            Assertions.assertEquals("2스트라이크", out.toString());
        }
    }

    @Test
    public void 볼_스트라이크_Exception_Test() throws WrongGuessException {
        Assertions.assertThrows(WrongGuessException.class, () -> {
            int[] guessArray = {1, 3, 2};
            markingManager.mark(guessArray);
        });
    }

    @Test
    public void 볼_스트라이크_print_Test() throws WrongGuessException {
        try {
            int[] guessArray = {1, 3, 2};
            markingManager.mark(guessArray);
        } catch (WrongGuessException e) {
            Assertions.assertEquals("2볼 1스트라이크", out.toString());
        }
    }
}