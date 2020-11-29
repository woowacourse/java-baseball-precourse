package GameConsole;

import numbers.UserSelectNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public int playGame(ArrayList<Integer> answerNumber, Scanner scanner) {
        UserSelectNumber userSelectString = UserSelectNumber.createUserSelectNumber();
        ArrayList<Integer> userSelectNumber;
        while(true){
            userSelectString.setUserSelectNumber(scanner);

        }
        return selectContinue(scanner);
    }

    public int selectContinue(Scanner scanner) {

        return scanner.nextInt();
    }

    public boolean continueGame(int result) {

        return true;
    }
}
