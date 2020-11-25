package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int START_COUNT = 1;
    private static final int END_COUNT = 9;
    private static final int BASEBALL_GAME_NUMBER_COUNT = 3;

    public int number;

    public Computer() {
        List<Integer> numbers = new ArrayList<>();

        number = makeComputerNumber(makeRandomNumbers(numbers));
    }

    private List<Integer> makeRandomNumbers(List<Integer> numbers) {
        int value = RandomUtils.nextInt(START_COUNT, END_COUNT);

        if (!numbers.contains(value)) {
            numbers.add(value);
        }

        if (numbers.size() >= BASEBALL_GAME_NUMBER_COUNT) {
            return numbers;
        }

        return makeRandomNumbers(numbers);
    }

    private int makeComputerNumber(List<Integer> numbers) {
        String value = "";

        for (int n : numbers) {
            value += Integer.toString(n);
        }

        return Integer.parseInt(value);
    }
}
