package baseball;

public class Printer {
    private static final String BALL_UNIT = "볼";
    private static final String STRIKE_UNIT = "스트라이크";

    /**
     * 점수를 넘겨 받아 출력합니다
     * @param ball 볼 점수
     * @param strike 스트라이크 점수
     */
    public void ballAndStrike(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + BALL_UNIT);
        }

        if (ball > 0 && strike > 0) {
            System.out.print(" ");
        }

        if (strike > 0) {
            System.out.print(strike + STRIKE_UNIT);
        }
        System.out.println();
    }

}