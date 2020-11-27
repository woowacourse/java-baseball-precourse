package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import utils.InputUtils;

import java.util.Iterator;
import java.util.Scanner;

public class BaseBallGame {
    private static int ruleStrike;
    private static int ruleBall;

    private static final int RESET = 0;

    public static void start(Scanner scanner) {
        Computer.makeBalls();
        User.makeBalls(InputUtils.checkUserInput(scanner.nextLine()));
    }


    private static void resetRules() {
        ruleStrike = RESET;
        ruleBall = RESET;
    }

    private static void compareBalls() {
        for (Iterator cb = Computer.balls.iterator(), ub = User.balls.iterator();
             cb.hasNext() && ub.hasNext(); ) {

            int computerNumber = (int) cb.next();
            int userNumber = (int) ub.next();

            isStrike(computerNumber, userNumber);
            isBall(computerNumber, userNumber);
        }
    }

    private static void isStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            ruleStrike += 1;
        }
    }

    private static void isBall(int computerNumber, int userNumber) {
        if (computerNumber != userNumber && Computer.balls.contains(userNumber)){
            ruleBall += 1;
        }
    }
}
