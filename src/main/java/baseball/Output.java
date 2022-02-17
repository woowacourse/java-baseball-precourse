package baseball;

import java.util.Arrays;

public class Output {

    private static final String REQUEST_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_FOR_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CHEAT_VERSION_ANSWER = "[[ Cheat Version ]] \nComputer Answer :: ";
    public static final String SCORE_NOTHING = "낫싱 ";
    public static final String SCORE_BALL = "볼 ";
    public static final String SCORE_STRIKE = "스트라이크 ";
    public static final int GAME_CONTINUE = -1;
    public static final int GAME_FINISH = 3;

    public static void requestUserNumber() {
        System.out.print(REQUEST_USER_NUMBER);
    }

    public static void requestRestart() {
        System.out.println(GAME_OVER);
        System.out.println(ASK_FOR_MORE_GAME);
    }

    public static void scoreResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(SCORE_NOTHING);
        } else if (ball == 0) {
            System.out.println(strike + SCORE_STRIKE);
        } else if (strike == 0) {
            System.out.println(ball + SCORE_BALL);
        }
    }

    public static void cheatVersion(int[] answer) {
        System.out.println(CHEAT_VERSION_ANSWER + Arrays.toString(answer));
    }

}
