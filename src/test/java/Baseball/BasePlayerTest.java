package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BasePlayerTest {

    private BasePlayer player;

    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outView));
    }

    @Test
    void wantToPlayAgain_return_true_with_1() {
        //given
        String input = "1";
        player = createBasePlayerForTest(input);

        //when & then
        assertTrue(player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }
    @Test
    void wantToPlayAgain_return_false_with_2() {
        //given
        String input = "2";
        player = createBasePlayerForTest(input);

        //when & then
        assertFalse(player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }
    @Test
    void wantToPlayAgain_throw_InvalidParameterException_with_other_number() {
        //given
        String input = "3";
        player = createBasePlayerForTest(input);

        //when & then
        assertThrows(InvalidParameterException.class, () -> player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }
    @Test
    void wantToPlayAgain_throw_InputMismatchException_with_notNumeric() {
        //given
        String input = "a";
        player = createBasePlayerForTest(input);

        //when & then
        assertThrows(InputMismatchException.class, () -> player.wantToPlayAgain());
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outView.toString());
    }

    private BasePlayer createBasePlayerForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        return new BasePlayer(scanner) {
            @Override
            public boolean wantToPlayAgain() {
                return super.wantToPlayAgain();
            }
        };
    }
}