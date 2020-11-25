package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BASEBALL_LENGTH = 3;

    private List<Integer> baseballNumber;

    private BaseBall(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public static BaseBall createRandomBaseBall() {
        List<Integer> randomDigit = getRandomDigit();
        return new BaseBall(randomDigit);
    }

    private static List<Integer> getRandomDigit() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < BASEBALL_LENGTH) {
            int randomDigit = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumber.contains(randomDigit)) {
                randomNumber.add(randomDigit);
            }
        }
        return randomNumber;
    }

    public List<Integer> getBaseballNumber(){
        return new ArrayList<>(baseballNumber);
    }
}
