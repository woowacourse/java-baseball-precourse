package baseball;

import gameconsole.BaseballGame;
import numbers.AnswerNumber;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean gameResult;

        do {
            AnswerNumber answerNumber = AnswerNumber.creatAnswerNumber();
            BaseballGame baseballGame = BaseballGame.createBaseballGame();
            gameResult = baseballGame.playGame(answerNumber.getAnswerNumber(), scanner);
        } while(gameResult);

        scanner.close();
    }
}
