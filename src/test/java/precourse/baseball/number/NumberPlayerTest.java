package precourse.baseball.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NumberPlayerTest {

    private NumberPlayer player;

    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outView));
    }

    @Test
    @DisplayName("test wantToPlayAgain with input: 1")
    void wantToPlayAgainReturnTrueWith1() {
        //given
        String input = "1";
        player = createBasePlayerForTest(input);

        //when & then
        assertTrue(player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }
    @Test
    @DisplayName("test wantToPlayAgain with input: 2")
    void wantToPlayAgainReturnFalseWith2() {
        //given
        String input = "2";
        player = createBasePlayerForTest(input);

        //when & then
        assertFalse(player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }
    @Test
    @DisplayName("test wantToPlayAgain with not appliable input")
    void wantToPlayAgainThrowInvalidParameterExceptionWithOtherNumber() {
        //given
        String input = "3";
        player = createBasePlayerForTest(input);

        //when & then
        assertThrows(InvalidParameterException.class, () -> player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }
    @Test
    @DisplayName("test wantToPlayAgain with not numeric input")
    void wantToPlayAgainThrowInputMismatchExceptionWithNotNumeric() {
        //given
        String input = "a";
        player = createBasePlayerForTest(input);

        //when & then
        assertThrows(InputMismatchException.class, () -> player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }

    private NumberPlayer createBasePlayerForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        return new NumberPlayer(scanner) {
            @Override
            public boolean wantToPlayAgain() {
                return super.wantToPlayAgain();
            }
        };
    }
}