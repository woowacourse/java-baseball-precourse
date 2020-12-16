package view;

public class OutputView {

    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String RIGHT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printBallAndStrike(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + BALL);
        }

        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }

        if (strike == 0 && ball == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    public static void printAnswerMessage() {
        System.out.println(RIGHT_ANSWER_MESSAGE);
    }

}
