package baseball;

import utils.RandomUtils;

import java.util.*;

public class BaseballNumber {
    private static final int DEFAULT_NUMBER_MAX_LENGTH = 3;
    private static final int DEFAULT_RANDOM_NUMBER_MIN = 1;
    private static final int DEFAULT_RANDOM_NUMBER_MAX = 9;

    private List<String> number;

    public BaseballNumber() {
        Set<String> randomSet = new HashSet<>();
        while (randomSet.size() < DEFAULT_NUMBER_MAX_LENGTH) {
            randomSet.add(String.valueOf(RandomUtils.nextInt(DEFAULT_RANDOM_NUMBER_MIN, DEFAULT_RANDOM_NUMBER_MAX)));
        }
        this.number = new ArrayList<>(randomSet);
    }

    public BaseballNumber(String playerInput) {
        String[] playerNumberArr = playerInput.split("");
        this.number = new ArrayList<>(Arrays.asList(playerNumberArr));
    }

    public int size() {
        return number.size();
    }

    public String getIndexValue(int index) {
        return number.get(index);
    }

    public boolean contains(String value) {
        return number.contains(value);
    }
}
