package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class NumberGenerator {

    private static final ArrayList<Integer> numbers = new ArrayList<>();
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static ArrayList<Integer> getRandomNumberNotRepeat() {
        while (numbers.size() < NUMBER_LENGTH) {
            int random = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);

            checkIntegerInList(random);
        }

        return numbers;
    }

    public static void checkIntegerInList(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

}

