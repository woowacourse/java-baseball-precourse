/*
 * Class:   Applicaction.java
 *
 * Version: 1.0.0
 *
 * Date:    2020-11-26
 *
 * Author:  Dong Gun Lee
 *
 */

package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application.playGame(scanner);
    }

    public static void playGame(Scanner scanner) {
        Boolean playCode;

        do {
            AnswerBalls answerBalls = new AnswerBalls();
            BaseBallGame baseBallGame = new BaseBallGame(scanner, answerBalls);
            playCode = baseBallGame.play();
        } while (playCode);
    }
}
