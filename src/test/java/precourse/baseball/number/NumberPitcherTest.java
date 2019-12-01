package precourse.baseball.number;

import org.junit.jupiter.api.*;
import precourse.baseball.number.errors.InvalidInputException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NumberPitcherTest {
    private NumberPitcher pitcher;
    private final ByteArrayOutputStream outView = new ByteArrayOutputStream();
    private Scanner scanner;

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outView));
    }

    @AfterEach
    void clear() {
        try {
            scanner.close();
        } catch (RuntimeException e) {
            System.out.println(String.format("테스트 중 다음과 같은 오류로 시스템을 종료합니다 : %s", e.getMessage()));
            System.exit(-1);
        }

    }

    @Test
    @DisplayName("test pitch with valid input")
    void pitchReturnBallsWithValidInput() {
        //given
        String input = "123";
        pitcher = createPitcherForTest(input);
        List<Integer> balls = new ArrayList<>(
                Arrays.asList(1,2,3)
        );

        //when & then
        assertEquals(balls, pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }
    @Test
    @DisplayName("test pitch with input which is too short")
    void pitchThrowInvalidInputExceptionWithInputWhichLengthIsShort() {
        //given
        String shortInput = "12";
        pitcher = createPitcherForTest(shortInput);

        //when & then
        assertThrows(InvalidInputException.class, () -> pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }
    @Test
    @DisplayName("test pitch with input which is too long")
    void pitchThrowInvalidInputExceptionWithInputWhichLengthIsLong() {
        //given
        String longInput = "1234";
        pitcher = createPitcherForTest(longInput);

        //when & then
        assertThrows(InvalidInputException.class, () -> pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }

    @Test
    @DisplayName("test pitch with not numeric input")
    void pitchThrowInvalidInputExceptionWithInputWhichIsNotNumeric() {
        //given
        String notNumericInput = "1a3";
        pitcher = createPitcherForTest(notNumericInput);

        //when & then
        assertThrows(InvalidInputException.class, () -> pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }

    private NumberPitcher createPitcherForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);
        return new NumberPitcher(scanner);
    }
}