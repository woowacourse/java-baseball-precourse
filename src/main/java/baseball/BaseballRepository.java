package baseball;

import domain.BaseBall;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseballRepository {
    public BaseBall createRandomBaseBall() {
        List<Integer> randomDigit = getRandomDigit();
        return new BaseBall(randomDigit);
    }

    private List<Integer> getRandomDigit() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < BaseBall.BASEBALL_LENGTH) {
            int randomDigit = RandomUtils.nextInt(BaseBall.MIN_DIGIT, BaseBall.MAX_DIGIT);
            if (!randomNumber.contains(randomDigit)) {
                randomNumber.add(randomDigit);
            }
        }
        return randomNumber;
    }

    public BaseBall createInputBaseBall(int inputNumber) {
        List<Integer> ballNumber = mapToList(inputNumber);
        return new BaseBall(ballNumber);
    }

    private List<Integer> mapToList(int baseBallNumber) {
        List<Integer> ballNumber = new ArrayList<>();
        for (int digit = 100; digit > 0; digit /= 10) {
            ballNumber.add(baseBallNumber / digit);
            baseBallNumber %= digit;
        }
        return ballNumber;
    }
}
