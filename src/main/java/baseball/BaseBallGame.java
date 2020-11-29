/*
 * Class:   BaseBallGame.java
 *
 * Version: 1.0.0
 *
 * Date:    2020-11-26
 *
 * Author:  Dong Gun Lee
 *
 */

package baseball;

import utils.BaseBallUtils;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallGame {
    private final Scanner scanner;
    private final AnswerBalls answerBalls;
    private static final int START_NUM = 0;
    private static final int CONTINUE_CODE = 1;
    private int strikes = START_NUM;
    private int balls = START_NUM;
    private ArrayList<Integer> inputBalls = new ArrayList<>();

    public BaseBallGame(Scanner scanner, AnswerBalls answerBalls){
        this.scanner = scanner;
        this.answerBalls = answerBalls;
    }

    public Boolean play() {
        int code;

        setGame();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        code = BaseBallUtils.isCodeRight(scanner);

        if (code == CONTINUE_CODE) {
            return true;
        }

        return false;
    }

    private void setGame() {
        do {
            strikes = START_NUM;
            balls = START_NUM;
            nextBalls();
            getHints();
            inputBalls.clear();
        } while (strikes < 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void nextBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.next();
        int ballLength = input.length();

        for (int i = 0; i < ballLength; i++) {
            inputBalls.add((int) Character.getNumericValue(input.charAt(i)));
        }

        BaseBallUtils.isBallsRight(inputBalls);
    }

    private void getHints() {
        for (int i = 0; i < inputBalls.size(); i++) {
            if (inputBalls.get(i).equals(answerBalls.getAnswerBalls().get(i))) {
                strikes++;
            }
        }

        for (int j = 0; j < inputBalls.size(); j++) {
            if (answerBalls.getAnswerBalls().contains(inputBalls.get(j))) {
                balls++;
            }
        }

        balls = balls - strikes;

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes == 0) {
            System.out.println(balls + "볼");
        } else if (balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }
}
