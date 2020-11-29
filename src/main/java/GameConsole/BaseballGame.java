package GameConsole;

import numbers.UserSelectNumber;
import views.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public boolean playGame(ArrayList<Integer> answerNumber, Scanner scanner) {
        UserSelectNumber userSelectString = UserSelectNumber.createUserSelectNumber();
        while(true){
            Output.printSelect();
            userSelectString.setUserSelectNumber(scanner);
            GameResult gameResult = GameResult.createGameResult();
            boolean resultStatus = gameResult.showResult(answerNumber, userSelectString.getUserSelectNumber());
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
