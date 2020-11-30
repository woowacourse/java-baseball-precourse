package baseball.generator;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    @Test
    public void randomNumberGeneratorTest(){
        String number = RandomNumberGenerator.getRandomNumber();
        assertEquals(number.length(), 3);
        assertEquals(Pattern.matches("[a-zA-Z]+", number), false);
    }
}