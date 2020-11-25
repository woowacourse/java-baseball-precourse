package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int START_COUNT = 1;
    private static final int END_COUNT = 9;
    private static final int BASEBALL_GAME_NUMBER_COUNT = 3;

    public List<Integer> numbers;

    public Computer() {
        List<Integer> numbers = new ArrayList<>();

        numbers = makeRandomNumbers(numbers);
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

    public void getResult(int playerNumber) {
        char[] playerNumberArray = Integer.toString(playerNumber).toCharArray();
        List<Integer> playerNumbers = new ArrayList<>();

        for (char c : playerNumberArray) {
            playerNumbers.add(Character.getNumericValue(c));
        }

        showResult(getBallCount(playerNumbers), getStrikeCount(playerNumbers));
    }

    private int getBallCount(List<Integer> playerNumbers) {
        return 0;
    }

    private int getStrikeCount(List<Integer> playerNumbers) {
        return 0;
    }

    private void showResult(int ballCount, int strikeCount) {

    }
}
