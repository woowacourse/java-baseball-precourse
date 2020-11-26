package baseball;

import domain.*;
import utils.StringConverter;
import validator.PositiveIntegerValidator;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        playOneCycle(scanner);
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
}
