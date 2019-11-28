package Baseball;

import Baseball.errors.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class NumberHitterTest {
    private NumberHitter hitter;


    @Test
    void hit_return_balls_with_valid_input() {
        //todo: test print
        //given
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        hitter = new NumberHitter(scanner);
        List<Integer> balls = new ArrayList<>(
                Arrays.asList(1,2,3)
        );

        //when & then
        assertEquals(balls, hitter.hit());
    }
    @Test
    void hit_throw_InvalidInputException_with_input_which_length_is_wrong() {
        //given
        String shortInput = "12";
        System.setIn(new ByteArrayInputStream(shortInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        hitter = new NumberHitter(scanner);

        //when & then
        assertThrows(InvalidInputException.class, () -> hitter.hit());

        //given
        String longInput = "1234";
        System.setIn(new ByteArrayInputStream(longInput.getBytes()));
        scanner = new Scanner(System.in);
        hitter = new NumberHitter(scanner);

        //when & then
        assertThrows(InvalidInputException.class, () -> hitter.hit());
    }

    @Test
    void hit_throw_InvalidInputException_with_input_which_is_not_numeric() {
        //given
        String notNumericInput = "1a3";
        System.setIn(new ByteArrayInputStream(notNumericInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        hitter = new NumberHitter(scanner);

        //when & then
        assertThrows(InvalidInputException.class, () -> hitter.hit());
    }


}