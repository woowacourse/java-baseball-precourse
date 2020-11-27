package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class InputTest {
    @Test
    public void input() {
        //given
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        Scanner scanner = new Scanner(in);
        Input input = new Input(scanner);

        //when
        Balls balls = input.enterNumberInput();
        List<Integer> ballNumbers = balls.getBalls();

        //then
        assertEquals( ballNumbers,balls.getBalls());
    }

}