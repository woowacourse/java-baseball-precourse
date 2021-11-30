package baseball;

import static baseball.StringUtil.*;

import baseball.inputmanager.GuessedNumberManager;
import baseball.inputmanager.InputManger;
import baseball.inputmanager.StartEndButton;

public class BaseBallGame {
    private static final InputManger<Integer[]> guessedNumberManager = new GuessedNumberManager();
    private static final InputManger<Integer> startEndButton = new StartEndButton();

    private GameResult result;
    private boolean end = false;

    public void start() {
        while (!end) {
            play();
            printGameEndMessage();
            end = isUserWantToEnd();
        }
    }

    private void play() {
        GivenNumber givenNumber = new GivenNumber(RandomNumberFactory.generate());
        do {
            printNumberRequestMessage();
            result = givenNumber.calculateGameResult((Integer[]) guessedNumberManager.getInput());
            printGameResult();
        } while (!isThreeStrike());
    }

    private boolean isUserWantToEnd() {
        return startEndButton.getInput() == END_BUTTON;
    }

    private boolean isThreeStrike() {
        return result.isThreeStrike();
    }

    private void printNumberRequestMessage() {
        System.out.print(NUMBER_REQUEST_MESSAGE);
    }

    private void printGameResult() {
        System.out.println(result.toPrint());
    }

    private void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
        System.out.println(START_END_BUTTON_MESSAGE);
    }
}
