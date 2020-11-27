package baseball.controller;

import baseball.model.ScoreBoard;
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
            ScoreBoard.resetBaord();
            Computer.makeBalls();

            BaseBallGame.runnable(scanner);

            GameView.printGameEnd();
        } while (isContinueGame(InputUtils.checkContinueInput(scanner.nextLine())));
    }

    private static boolean isContinueGame(String userInput) {
        return userInput.equals(CONTINUE_GAME);
    }

    private static void runnable(Scanner scanner) {
        while (!ScoreBoard.isThreeStrike()) {
            ScoreBoard.resetBaord();
            GameView.printPleaseInput();
            User.makeBalls(InputUtils.checkUserBallsInput(scanner.nextLine()));
            BaseBallGame.compareBalls();
            GameView.printGameResult(ScoreBoard.ball, ScoreBoard.strike);
        }
    }

    private static void compareBalls() {
        for (Iterator cb = Computer.balls.iterator(), ub = User.balls.iterator();
            cb.hasNext() && ub.hasNext(); ) {

            int computerNumber = (int) cb.next();
            int userNumber = (int) ub.next();

            ScoreBoard.updateBallCount(Computer.balls, computerNumber, userNumber);
            ScoreBoard.updateStrikeCount(computerNumber, userNumber);
        }
    }
}
