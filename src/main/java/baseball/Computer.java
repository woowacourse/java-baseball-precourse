package baseball;

import utils.RandomUtils;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int START_COUNT = 1;
    private static final int END_COUNT = 9;
    private static final int BASEBALL_GAME_NUMBER_COUNT = 3;
    private static final int NOTHING = 0;
    private static final int INDEX_START = 0;

    public List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
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

    public boolean getResult(int playerNumber) {
        char[] playerNumberArray = Integer.toString(playerNumber).toCharArray();
        List<Integer> playerNumbers = new ArrayList<>();

        for (char c : playerNumberArray) {
            playerNumbers.add(Character.getNumericValue(c));
        }

        return showResultWithWinState(getBallCount(playerNumbers), getStrikeCount(playerNumbers));
    }

    private int getBallCount(List<Integer> playerNumbers) {
        return calculateBallCount(playerNumbers, NOTHING, INDEX_START) - getStrikeCount(playerNumbers);
    }

    private int calculateBallCount(List<Integer> numbers, int ballCount, int index) {
        if (index >= BASEBALL_GAME_NUMBER_COUNT) {
            return ballCount;
        }

        if (this.numbers.contains(numbers.get(index))) {
            ballCount++;
        }

        return calculateBallCount(numbers, ballCount, ++index);
    }

    private int getStrikeCount(List<Integer> playerNumbers) {
        return calculateStrikeCount(playerNumbers, NOTHING, INDEX_START);
    }

    private int calculateStrikeCount(List<Integer> numbers, int strikeCount, int index) {
        if (index >= BASEBALL_GAME_NUMBER_COUNT) {
            return strikeCount;
        }

        if (this.numbers.get(index).equals(numbers.get(index))) {
            strikeCount++;
        }

        return calculateBallCount(numbers, strikeCount, ++index);
    }

    private boolean showResultWithWinState(int ballCount, int strikeCount) {
        if (ballCount == NOTHING && strikeCount == NOTHING) {
            OutputView.printResultNothing();
        }

        if (ballCount > NOTHING) {
            OutputView.printResultBallCount(ballCount);
        }

        if (strikeCount > NOTHING) {
            OutputView.printResultStrikeCount(strikeCount);
        }
        
        if (strikeCount >= BASEBALL_GAME_NUMBER_COUNT) {
            OutputView.printGameEnd();
            return true;
        }

        return false;
    }
}
