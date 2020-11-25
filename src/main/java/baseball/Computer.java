package baseball;

import utils.RandomUtils;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int START_COUNT = 1;
    private static final int END_COUNT = 9;
    private static final int BASEBALL_GAME_NUMBER_COUNT = 9;
    private static final int NOTHING = 0;

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
        int ballCount = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (numbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }

        return ballCount - getStrikeCount(playerNumbers);
    }

    private int getStrikeCount(List<Integer> playerNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i).equals(numbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private boolean showResultWithWinState(int ballCount, int strikeCount) {
        if (ballCount == NOTHING && strikeCount == NOTHING) {
            OutputView.printResultNothing();
        }

        if (ballCount > 0) {
            OutputView.printResultBallCount(ballCount);
        }

        if (strikeCount > 0) {
            OutputView.printResultStrikeCount(strikeCount);
        }
        
        if (strikeCount >= 3) {
            OutputView.printGameEnd();
            return true;
        }

        return false;
    }
}
