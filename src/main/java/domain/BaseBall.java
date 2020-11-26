package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    private static final int BASEBALL_LENGTH = 3;

    private List<Integer> baseballNumber;

    private BaseBall(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseBall createRandomBaseBall() {
        List<Integer> randomDigit = getRandomDigit();
        return new BaseBall(randomDigit);
    }

    public static BaseBall createBaseBall(int baseBallNumber) throws IllegalStateException {
        validateNumber(baseBallNumber);
        List<Integer> ballNumber = mapToList(baseBallNumber);
        return new BaseBall(ballNumber);
    }

    private static List<Integer> getRandomDigit() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < BASEBALL_LENGTH) {
            int randomDigit = RandomUtils.nextInt(MIN_DIGIT, MAX_DIGIT);
            if (!randomNumber.contains(randomDigit)) {
                randomNumber.add(randomDigit);
            }
        }
        return randomNumber;
    }

    private static void validateNumber(int baseBallNumber) throws IllegalStateException {
        final int MAX_NUMBER = 999;
        final int MIN_NUMBER = 100;
        if (baseBallNumber > MAX_NUMBER || baseBallNumber < MIN_NUMBER) {
            throw new IllegalStateException("세자리 숫자를 입력해주세요.");
        }
    }

    private static List<Integer> mapToList(int baseBallNumber) {
        List<Integer> ballNumber = new ArrayList<>();
        for (int digit = 100; digit > 0; digit /= 10) {
            ballNumber.add(baseBallNumber / digit);
            baseBallNumber %= digit;
        }
        return ballNumber;
    }

    public boolean containsNumber(int number) {
        return baseballNumber.contains(number);
    }

    public boolean hasNumber(int index, int number) {
        return baseballNumber.get(index) == number;
    }

    public int getNumber(int index) {
        return baseballNumber.get(index);
    }

    public int size() {
        return baseballNumber.size();
    }
}
