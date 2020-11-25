package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballUtilsTest {

    static final int NUMBER_COUNT = 3;
    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;

    @Test
    public void randomNumbersCountTest() {
        int[] randomNumbers = BaseballUtils.generateRandomNumbers();

        assertThat(randomNumbers.length).isEqualTo(NUMBER_COUNT);
    }

    @Test
    public void randomNumbersValidTest() {
        int[] randomNumbers = BaseballUtils.generateRandomNumbers();

        boolean isValidRandomNumber = true;

        for (int random : randomNumbers) {
            if (MIN_NUMBER >= random || random > MAX_NUMBER) {
                isValidRandomNumber = false;
                break;
            }
        }

        assertThat(isValidRandomNumber).isTrue();
    }

    @Test
    public void randomNumbersDuplicatedTest() {
        int[] randomNumbers = BaseballUtils.generateRandomNumbers();
        boolean[] checkDuplicated = new boolean[MAX_NUMBER + 1];

        boolean isDuplicatedRandomNumber = true;

        for (int random : randomNumbers) {
            if (checkDuplicated[random]) {
                isDuplicatedRandomNumber = false;
                break;
            }

            checkDuplicated[random] = true;
        }

        assertThat(isDuplicatedRandomNumber).isTrue();
    }

}
