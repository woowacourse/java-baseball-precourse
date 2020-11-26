package utils;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
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

    @Test
    public void Should_ParsingNumbers_When_ForValidInput() {
        String data = "123";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int[] playerNumbers = BaseballUtils.getPlayerNumbers(scanner);

        int[] testNumbers = new int[]{1,2,3};
        assertThat(playerNumbers).isEqualTo(testNumbers);
    }

    @Test
    public void Should_ThrownException_When_ForNotIntInput() {
        String data = "Hello";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> BaseballUtils.getPlayerNumbers(scanner));
    }

    @Test
    public void Should_ThrownException_When_ForNotThreeIntInput() {
        String data = "1234";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> BaseballUtils.getPlayerNumbers(scanner));
    }

    @Test
    public void Should_ThrownException_When_ForZeroIntInput() {
        String data = "204";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> BaseballUtils.getPlayerNumbers(scanner));
    }

    @Test
    public void Should_ThrownException_When_ForDuplicatedIntInput() {
        String data = "224";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> BaseballUtils.getPlayerNumbers(scanner));
    }
}
