package baseball.domain;

import baseball.validator.PositiveIntegerValidator;
import baseball.validator.RestartCommandValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import utils.StringConverter;

import java.util.Scanner;

public class BaseballGame {
    private static final String TERMINATE = "2";

    private BaseballGame() {
    }

    public static void playBaseball(Scanner scanner) {
        GameStatus gameStatus = new GameStatus(Status.ONGOING);
        do {
            playOneCycle(scanner);
            OutputView.printCongratulationMessage();
            decideRestartOrTerminate(scanner, gameStatus);
        } while (gameStatus.isOngoing());
    }

    private static void playOneCycle(Scanner scanner) {
        BaseballNumber answer = BaseballNumberCreator.createBaseballNumber();
        GameStatus gameStatus = new GameStatus(Status.ONGOING);
        do {
            BaseballNumber userBaseballNumber = makeUserBaseballNumber(scanner);
            Score score = ScoreCalculator.calculateScore(answer, userBaseballNumber);
            OutputView.printScore(score);
            terminateIfThreeStrike(score, gameStatus);
        } while (gameStatus.isOngoing());
    }

    private static BaseballNumber makeUserBaseballNumber(Scanner scanner) {
        String threeDigitNumber = InputView.getThreeDigitNumber(scanner);
        BaseballNumber userBaseballNumber;
        try {
            PositiveIntegerValidator.validatePositiveInteger(threeDigitNumber);
            userBaseballNumber = BaseballNumberCreator.createBaseballNumber(StringConverter.toIntList(threeDigitNumber));
        } catch (IllegalArgumentException e) {
            OutputView.printMessageAndNewLine(e.getMessage());
            userBaseballNumber = makeUserBaseballNumber(scanner);
        }
        return userBaseballNumber;
    }

    private static void terminateIfThreeStrike(Score score, GameStatus gameStatus) {
        if (score.isThreeStrike()) {
            gameStatus.terminate();
        }
    }

    private static void decideRestartOrTerminate(Scanner scanner, GameStatus gameStatus) {
        String restartCommand = InputView.getRestartCommand(scanner);
        try {
            RestartCommandValidator.validateRestartCommand(restartCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printMessageAndNewLine(e.getMessage());
            decideRestartOrTerminate(scanner, gameStatus);
        }
        terminateIfRequest(restartCommand, gameStatus);
    }

    private static void terminateIfRequest(String restartCommand, GameStatus gameStatus) {
        if (restartCommand.equals(TERMINATE)) {
            gameStatus.terminate();
        }
    }
}
