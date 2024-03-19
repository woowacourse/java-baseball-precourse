package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {

    @Test
    public void testIfEmpty(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.makeRandom();
        Assertions.assertThat(randomNumberGenerator.numberList).isNotEmpty();
    }

    @Test
    void testMakeRandomPopulatesListCorrectly() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        rng.makeRandom(); // Call the method to test

        // Assert the list is populated with exactly three numbers
        assertEquals(3, rng.numberList.size(), "numberList should contain exactly three numbers");

        // Assert each number is within the expected range
        assertTrue(rng.numberList.stream().allMatch(num -> num >= 0 && num <= 9),
                "All numbers in numberList should be between 0 and 9");
    }

    @Test
    void testRandomnessOverMultipleExecutions() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        HashMap<Integer, Integer> numberOccurrences = new HashMap<>();
        int iterations = 1000;

        for (int i = 0; i < iterations; i++) {
            rng.numberList.clear(); // Clear the list before generating new numbers
            rng.makeRandom();
            for (Integer number : rng.numberList) {
                numberOccurrences.merge(number, 1, Integer::sum);
            }
        }

        // Assert that each number has been generated, implying a minimum level of randomness
        for (int i = 0; i <= 9; i++) {
            assertTrue(numberOccurrences.containsKey(i), "Number " + i + " was never generated.");
        }

        // Optional: Print occurrences for manual inspection
        numberOccurrences.forEach((key, value) -> System.out.println(key + " occurred " + value + " times."));

        // Assert a basic level of distribution
        numberOccurrences.values().forEach(count -> {
            assertTrue(count > (iterations * 3 / 10 * 0.5), "One or more numbers are significantly less frequent than expected.");
            assertTrue(count < (iterations * 3 / 10 * 1.5), "One or more numbers are significantly more frequent than expected.");
        });
    }
}
