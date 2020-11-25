package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private static final int LIST_SIZE = 3;
    private static final int LOWER_BOUNDARY = 0;
    private static final int UPPER_BOUNDARY = 9;

    private final List<Character> intToCharacterArray = new ArrayList<>();

    public List<Character> getRandomNumbers() {
        for (int i = 0; i < LIST_SIZE; i++) {
            intToCharacterArray.add((char) RandomUtils.nextInt(LOWER_BOUNDARY, UPPER_BOUNDARY));
        }
        return intToCharacterArray;
    }
}
