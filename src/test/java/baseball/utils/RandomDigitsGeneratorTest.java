package baseball.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomDigitsGeneratorTest {

    static List<Integer> randomDigits;

    @BeforeAll
    public static void beforeAll() {
        randomDigits = RandomDigitsGenerator.createRandomDigits();
    }

    @Test
    public void 생성한_난수_개수_테스트() {
        assertEquals(RandomDigitsGenerator.RANDOM_DIGIT_COUNT, randomDigits.size());
    }
    @Test
    public void 서로_다른_수_테스트() {
        for(int randomDigit : randomDigits) {
            assertEquals(1, Collections.frequency(randomDigits, randomDigit));
        }
    }
}