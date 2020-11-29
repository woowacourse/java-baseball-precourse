package baseball;

import GameConsole.BaseballGame;
import numbers.AnswerNumber;
import numbers.UserSelectNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        AnswerNumber answerNumber = AnswerNumber.creatAnswerNumber();
        BaseballGame baseballGame = BaseballGame.createBaseballGame();
        int gameResult;
        ArrayList<Integer> answer;
        do {
            answer = answerNumber.getAnswerNumber();
            System.out.print("숫자를 입력해주세요 : ");
            gameResult = baseballGame.playGame(answer, scanner);
        } while(baseballGame.continueGame(gameResult));

        scanner.close();
    }
}
