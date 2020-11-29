package baseball.modules;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    private static final int TEST_NUMBER_SIZE = 3;
    static final int TEST_ITERATION = 10000;

    @Test
    public void checkGeneratedNumberNotDuplicated() {
        NumberGenerator numberGenerator = new NumberGenerator(TEST_NUMBER_SIZE);
        boolean isDuplicated = false;

        for (int i = 0; i < TEST_ITERATION; i++) {
            numberGenerator.generate();
            int[] generatedNumber = numberGenerator.getNumber();
            if (!ExceptionChecker.isArrayElementsAreUnique(generatedNumber)) {
                isDuplicated = true;
                break;
            }
        }

        assertFalse(isDuplicated);
    }

    @Test
    public void checkGeneratedNumberActuallyRandom() {
        NumberGenerator numberGenerator = new NumberGenerator(TEST_NUMBER_SIZE);
        HashMap<Integer, Integer> numberCounter = new HashMap<>();

        for (int i = 0; i < TEST_ITERATION; i++) {
            numberGenerator.generate();
            int[] generatedNumber = numberGenerator.getNumber();
            count(numberCounter, generatedNumber);
        }

        // 모든 숫자가 골고루 나왔는지 눈으로 확인한다
        for (int key : numberCounter.keySet()) {
            System.out.printf("%d : %d%n", key, numberCounter.get(key));
        }
    }

    private void count(HashMap<Integer, Integer> counter, int[] number) {
        if (ExceptionChecker.isNull(counter) || ExceptionChecker.isNull(number)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < number.length; i++) {
            int currentNumber = number[i];
            if (!counter.containsKey(currentNumber)) {
                counter.put(currentNumber, 0);
            }
            counter.put(currentNumber, counter.get(currentNumber) + 1);
        }
    }
}
