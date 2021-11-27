package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.regex.Pattern;

public class NumberGeneratorTest {
    @Test
    public void generateRandomNumber() {
        String randomNumber = NumberGenerator.generateRandomNumber();
        Assertions.assertEquals(3, randomNumber.length(),
                "길이가 3인 숫자가 아님");

        String pattern = "^[0-9]*$";
        Assertions.assertTrue(Pattern.matches(pattern, randomNumber),
                "1에서 9사이의 정수에 해당하지 않는 수가 포함됨");
    }
}
