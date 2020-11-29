package GameConsole;

import numbers.UserSelectNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {

    public static BaseballGame createBaseballGame() {
        return new BaseballGame();
    }

    public int playGame(ArrayList<Integer> answerNumber, Scanner scanner) {
        UserSelectNumber userSelect = UserSelectNumber.createUserSelectNumber(scanner);
        ArrayList<Integer> userSelectNumber;
        //do {

            userSelectNumber = userSelect.getUserSelectNumber();
        //} while (isCorrectAnswer(answerNumber, userSelectNumber));
        return selectContinue(scanner);
    }

    public int selectContinue(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }

    public boolean continueGame(int result) {

        return true;
    }
}
