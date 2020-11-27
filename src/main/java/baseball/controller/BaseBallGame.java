package baseball.controller;

import baseball.model.CompareResult;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameView;
import utils.InputUtils;

import java.util.Iterator;
import java.util.Scanner;


public class BaseBallGame {
    private static final String CONTINUE_GAME = "1";

    public static void start(Scanner scanner) {
        do {
            CompareResult.resetResult();
            Computer.makeBalls();

            runnable(scanner);

            GameView.printGameEnd();
        } while (isContinueGame(InputUtils.checkContinueInput(scanner.nextLine())));
    }

    private static boolean isContinueGame(String userInput) {
        if (userInput.equals(CONTINUE_GAME)) {
            return true;
        }

        return false;
    }

    private static void runnable(Scanner scanner) {
        while (!CompareResult.isThreeStrike()) {
            GameView.printPleaseInput();
            User.makeBalls(InputUtils.checkUserBallsInput(scanner.nextLine()));
            CompareResult.resetResult();

            compareBalls();

            GameView.printGameResult(CompareResult.ball, CompareResult.strike);
        }
    }

    private static void compareBalls() {
        for (Iterator cb = Computer.balls.iterator(), ub = User.balls.iterator();
             cb.hasNext() && ub.hasNext(); ) {

            int computerNumber = (int) cb.next();
            int userNumber = (int) ub.next();

            isBall(computerNumber, userNumber);
            isStrike(computerNumber, userNumber);
        }
    }

    private static void isBall(int computerNumber, int userNumber) {
        if (computerNumber != userNumber && Computer.balls.contains(userNumber)) {
            CompareResult.ball += 1;
        }
    }

    private static void isStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            CompareResult.strike += 1;
        }
    }
}
