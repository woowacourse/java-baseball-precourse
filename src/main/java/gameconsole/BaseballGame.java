package gameconsole;

import numbers.UserSelectNumber;
import utils.UserInputValidator;
import views.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public boolean playGame(ArrayList<Integer> answerNumber, Scanner scanner) {
        UserSelectNumber userSelectNumber = UserSelectNumber.createUserSelectNumber();

        while (true) {
            Output.printSelect();
            GameResult gameResult = GameResult.createGameResult();
            ArrayList<Integer> userNumber;

            try {
                userSelectNumber.setUserSelectNumber(scanner);
                userNumber = userSelectNumber.getUserSelectNumber();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                continue;
            }

            boolean resultStatus = gameResult.showResult(answerNumber, userNumber);

            if (resultStatus) {
                Output.printEndGame();
                break;
            }
        }
        return selectContinue(scanner);
    }

    public boolean selectContinue(Scanner scanner) {
        Output.printContinue();
        String continueSelect = scanner.nextLine();
        boolean selectResult;    // 게임을 한번 더 할지의 여부(false : 그만, true : 계속)
        try {
            UserInputValidator.isValidEndCode(continueSelect);
            selectResult = continueSelect.equals("1");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            selectResult = selectContinue(scanner);
        }

        return selectResult;
    }
}
