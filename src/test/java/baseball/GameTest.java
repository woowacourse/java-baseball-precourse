package baseball;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void generateRandomNumber() {
        Game game = new Game();
        String randomNumber = game.generateRandomNumber();
        Assertions.assertEquals(3, randomNumber.length(),
                "길이가 3인 숫자가 아님");

        String pattern = "^[0-9]*$";
        Assertions.assertTrue(Pattern.matches(pattern, randomNumber),
                "1에서 9사이의 정수에 해당하지 않는 수가 포함됨");
    }
}