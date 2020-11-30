package gameconsole;

import numbers.UserSelectNumber;
import views.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public boolean playGame(ArrayList<Integer> answerNumber, Scanner scanner) {
        UserSelectNumber userSelectNumber = UserSelectNumber.createUserSelectNumber();
        while(true){
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
        if (continueSelect.equals("1")) {
            return true;
        } else if (continueSelect.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1, 2중의 하나를 입력해주세요");
        }
    }
}
