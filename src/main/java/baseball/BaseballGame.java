package baseball;

import domain.Computer;
import view.InputView;
import view.OutputView;

public class BaseballGame {
    private static final int FIRST_INDEX = 0;
    private static final int NUMBERS_LENGTH = 3;
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;

    private Computer computer;
    private String computerNumbers;
    private String playerNumbers;
    private int strikeCount;
    private int ballCount;


    public BaseballGame() {
        computer = new Computer();
    }

    public void play() {
        computerNumbers = computer.createComputerNumbers();
        do {
            playerNumbers = InputView.inputPlayerNumbers();
            strikeCount = 0;
            ballCount = 0;
            compareNumbers(computerNumbers, playerNumbers);
        } while (strikeCount != MAX_COUNT);
        OutputView.printCorrectAnswer();
    }

    private void compareNumbers(String computerNumbers, String playerNumbers) {
        countStrikeBall(computerNumbers, playerNumbers);
        OutputView.printStrikeBall(strikeCount, ballCount);
    }

    private void countStrikeBall(String computerNumbers, String playerNumbers) {
        for(int i=FIRST_INDEX; i<NUMBERS_LENGTH; i++) {
            if(isStrike(computerNumbers, playerNumbers, i)) {
                strikeCount++;
            }
            if(isBall(computerNumbers, playerNumbers, i)) {
                ballCount++;
            }
        }
    }

    private boolean isStrike(String computerNumbers, String playerNumbers, int index) {
        if(computerNumbers.charAt(index) == playerNumbers.charAt(index)) {
            return true;
        }
        return false;
    }

    private boolean isBall(String computerNumbers, String playerNumbers, int index) {
        if(computerNumbers.contains(String.valueOf(playerNumbers.charAt(index)))
                && computerNumbers.charAt(index) != playerNumbers.charAt(index) ) {
            return true;
        }
        return false;
    }
}


