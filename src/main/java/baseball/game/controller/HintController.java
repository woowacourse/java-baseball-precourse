package baseball.game.controller;

import baseball.game.constants.BaseballGameConst;

import static baseball.game.constants.BaseballGameConst.RANDOM_NUMBER_COUNTS;

public class HintController {

    private static int strike;
    private static int ball;

    public HintController() {
        strike = 0;
        ball = 0;
    }

    public static boolean checkAnswer(int[] randomNumber, int[] userInput) {
        strike = getStrikeCount(randomNumber, userInput);
        ball = getBallCount(randomNumber, userInput);
        printHints(strike, ball);
        return (strike == 3);
    }

    private static void printHints(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike+"스트라이크");
        } else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    private static int getBallCount(int[] randomNumber, int[] userInput) {
        int count = 0;
        for (int i = 0; i < RANDOM_NUMBER_COUNTS; i++) {
            for (int j = 0; j < RANDOM_NUMBER_COUNTS; j++) {
                if (i != j && randomNumber[i] == userInput[j])
                    count++;
            }
        }
        return count;
    }

    private static int getStrikeCount(int[] randomNumber, int[] userInput) {
        int count = 0;
        for (int i = 0; i < RANDOM_NUMBER_COUNTS; i++) {
            if (randomNumber[i] == userInput[i])
                count++;
        }
        return count;
    }
}
