/*
 * Class:   BaseBallUtils.java
 *
 * Version: 1.0.0
 *
 * Date:    2020-11-29
 *
 * Author:  Dong Gun Lee
 *
 */

import baseball.AnswerBalls;
import baseball.BaseBallGame;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallGameTest {
    private static AnswerBalls answerBalls;

    @BeforeAll
    public static void setUp() {
        answerBalls = new AnswerBalls();
    }

    @AfterAll
    public static void tearDown() {
    }

    @Test
    public void playGameTest() {
        Scanner scanner;
        BaseBallGame baseBallGame;
        ArrayList<Integer> ballsNum = answerBalls.getAnswerBalls();
        String ballStr = "";

        for (int num : ballsNum) {
            ballStr += Integer.toString(num);
        }

        scanner = new Scanner(ballStr);
        baseBallGame = new BaseBallGame(scanner, answerBalls);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    baseBallGame.play();})
                .withMessage("한 자리의 숫자만 입력해주세요.");
    }
}
