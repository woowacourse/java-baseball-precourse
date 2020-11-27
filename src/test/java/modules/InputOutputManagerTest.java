package modules;

import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.GameManager;
import java.util.Arrays;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class InputOutputManagerTest {
    static final String USER_INPUT_NUMBER = "456";
    static final int[] NUMBER_ANSWER = { 4, 5, 6 };

    @Test
    public void testNumberInput(){
        setNumberInputStream();
        InputOutputManager inputOutputManager = new InputOutputManager(new Scanner(System.in), GameManager.NUMBER_SIZE);

        int[] number = inputOutputManager.askUserInputNumber();
        System.out.println(USER_INPUT_NUMBER);
        System.out.print("Output : ");
        for(int i = 0; i < number.length; i++){
            System.out.print(number[i]);
        }

        assertTrue(Arrays.equals(number, NUMBER_ANSWER));
    }

    private void setNumberInputStream(){
        InputStream inputStream = new ByteArrayInputStream(USER_INPUT_NUMBER.getBytes());
        System.setIn(inputStream);
    }
}
