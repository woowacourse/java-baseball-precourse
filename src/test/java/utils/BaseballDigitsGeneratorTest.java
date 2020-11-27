package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballDigitsGeneratorTest {

    @Test
    public void 난수가_세_자리인지() {
        // given, when
        List<Integer> randomDigits = BaseballDigitsGenerator.generateRandomDigitsList();

        // then
        assertEquals(BaseballDigitsGenerator.BASEBALL_LEN, randomDigits.size());
    }

    @Test
    public void 난수가_모두_다른_숫자인지() {
        // given, when
        List<Integer> randomDigits = BaseballDigitsGenerator.generateRandomDigitsList();
        boolean[] checkDuplicate = new boolean[BaseballDigitsGenerator.BASEBALL_NUM_MAX + 1];

        // then
        for (int digit : randomDigits) {
            assertEquals(false, checkDuplicate[digit]);
            checkDuplicate[digit] = true;
        }
    }
}