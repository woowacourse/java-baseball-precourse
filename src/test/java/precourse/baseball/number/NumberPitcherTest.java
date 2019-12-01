package precourse.baseball.number;

import org.junit.jupiter.api.DisplayName;
import precourse.baseball.number.errors.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outView));
    }

    @Test
    @DisplayName("test pitch with valid input")
    void pitchReturnBallsWithValidInput() {
        //given
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        pitcher = new NumberPitcher(scanner);
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
        System.setIn(new ByteArrayInputStream(shortInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        pitcher = new NumberPitcher(scanner);

        //when & then
        assertThrows(InvalidInputException.class, () -> pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }
    @Test
    @DisplayName("test pitch with input which is too long")
    void pitchThrowInvalidInputExceptionWithInputWhichLengthIsLong() {
        //given
        String longInput = "1234";
        System.setIn(new ByteArrayInputStream(longInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        pitcher = new NumberPitcher(scanner);

        //when & then
        assertThrows(InvalidInputException.class, () -> pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }

    @Test
    @DisplayName("test pitch with not numeric input")
    void pitchThrowInvalidInputExceptionWithInputWhichIsNotNumeric() {
        //given
        String notNumericInput = "1a3";
        System.setIn(new ByteArrayInputStream(notNumericInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        pitcher = new NumberPitcher(scanner);

        //when & then
        assertThrows(InvalidInputException.class, () -> pitcher.pitch());
        assertEquals("숫자를 입력해주세요 : ", outView.toString());
    }
}