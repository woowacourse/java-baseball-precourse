
/*
 * OutputUtil.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.utils;

import game.domain.MatchResult;
import game.domain.Numbers;

public class OutputUtil {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String BLANK = " ";
    public static final String GAME_FINISH_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    /**
     * This method is used to print the error message.
     * @param e exception
     */
    public static void showError(Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * This method is used to print result of matching as a hint.
     * @param result including counts of strike and ball.
     */
    public static void showHint(MatchResult result) {
        boolean isExistStrike = showCountOfStrike(result);
        boolean isExistBall = showCountOfBall(result);
        if (!isExistBall && !isExistStrike) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    private static boolean showCountOfStrike(MatchResult result) {
        if (result.isExistStrike()) {
            System.out.print(result.getStrikeCount());
            System.out.print(STRIKE);
            System.out.print(BLANK);
            return true;
        }
        return false;
    }

    private static boolean showCountOfBall(MatchResult result) {
        if (result.isExistBall()) {
            System.out.print(result.getBallCount());
            System.out.print(BALL);
            return true;
        }
        return false;
    }

    public static void showFinalResult() {
        System.out.print(Numbers.SIZE);
        System.out.println(GAME_FINISH_MESSAGE);
    }
}
