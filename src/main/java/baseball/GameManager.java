package baseball;

import utils.RandomUtils;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final int START_COUNT = 1;
    private static final int END_COUNT = 9;
    private static final int BASEBALL_GAME_NUMBER_COUNT = 3;
    private static final int NOTHING = 0;
    private static final int INDEX_START = 0;

    private List<String> numbers;

    public GameManager() {
        numbers = makeRandomNumbers(new ArrayList<>());
    }

    private List<String> makeRandomNumbers(List<String> numbers) {
        String value = Integer.toString(RandomUtils.nextInt(START_COUNT, END_COUNT));

        if (!numbers.contains(value)) {
            numbers.add(value);
        }

        if (numbers.size() >= BASEBALL_GAME_NUMBER_COUNT) {
            return numbers;
        }

        return makeRandomNumbers(numbers);
    }

    public boolean getResult(String playerNumber) {
        char[] playerNumberArray = playerNumber.toCharArray();
        List<String> playerNumbers = new ArrayList<>();

        for (char c : playerNumberArray) {
            playerNumbers.add(String.valueOf(c));
        }

        return showResultWithWinState(getBallCount(playerNumbers), getStrikeCount(playerNumbers));
    }

    private int getBallCount(List<String> playerNumbers) {
        return calculateBallCount(playerNumbers, NOTHING, INDEX_START) - getStrikeCount(playerNumbers);
    }

    private int calculateBallCount(List<String> numbers, int ballCount, int index) {
        if (index >= BASEBALL_GAME_NUMBER_COUNT) {
            return ballCount;
        }

        if (this.numbers.contains(numbers.get(index))) {
            ballCount++;
        }

        return calculateBallCount(numbers, ballCount, ++index);
    }

    private int getStrikeCount(List<String> playerNumbers) {
        return calculateStrikeCount(playerNumbers, NOTHING, INDEX_START);
    }

    private int calculateStrikeCount(List<String> numbers, int strikeCount, int index) {
        if (index >= BASEBALL_GAME_NUMBER_COUNT) {
            return strikeCount;
        }

        if (this.numbers.get(index).equals(numbers.get(index))) {
            strikeCount++;
        }

        return calculateStrikeCount(numbers, strikeCount, ++index);
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
