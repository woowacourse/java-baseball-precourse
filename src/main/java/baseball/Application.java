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
            gameResult = baseballGame.playGame(answer);
        } while(baseballGame.continueGame(gameResult));

        scanner.close();
    }
}
