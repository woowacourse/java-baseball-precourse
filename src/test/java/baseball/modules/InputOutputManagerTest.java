package baseball.modules;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class InputOutputManagerTest {
    private static final int TEST_NUMBER_SIZE = 3;
    private static final String USER_INPUT_NUMBER = "456";
    private static final int[] NUMBER_ANSWER = { 4, 5, 6 };

    @Test
    public void testNumberInput() {
        setNumberInputStream();
        InputOutputManager inputOutputManager = new InputOutputManager(new Scanner(System.in), TEST_NUMBER_SIZE);

        int[] number = inputOutputManager.askUserInputNumber();
        System.out.println(USER_INPUT_NUMBER);
        System.out.print("Output : ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }

        assertTrue(Arrays.equals(number, NUMBER_ANSWER));
    }

    private void setNumberInputStream() {
        InputStream inputStream = new ByteArrayInputStream(USER_INPUT_NUMBER.getBytes());
        System.setIn(inputStream);
    }
}
