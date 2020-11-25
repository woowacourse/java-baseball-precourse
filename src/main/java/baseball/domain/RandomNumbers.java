package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    public static final int LIST_SIZE = 3;
    private static final int LOWER_BOUNDARY = 1;
    private static final int UPPER_BOUNDARY = 9;

    private final List<Integer> intToCharacterArray = new ArrayList<>();

    public List<Integer> getRandomNumbers() {
        for (int i = 0; i < LIST_SIZE; i++) {
            int newNumber = RandomUtils.nextInt(LOWER_BOUNDARY, UPPER_BOUNDARY);
            if (intToCharacterArray.stream().anyMatch(integer -> integer.equals(newNumber))) {
                i--;
            } else {
                intToCharacterArray.add(newNumber);
            }
        }
        return intToCharacterArray;
    }
}
