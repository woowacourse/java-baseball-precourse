package baseball.view;

public class OutputView {
    private static final String STRIKE_MENT = " 스트라이크";
    private static final String BALL_MENT = "볼";
    private static final String CORRECT_ANSWER_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MENT = "낫씽";
    private static final String END_GAME_MENT = "수고하셨습니다. 게임이 종료 됩니다.";
    private static final String INPUT_ERROR_MENT = "올바르지 않은 입력입니다. 1~9까지 숫자중 중복없이 3개를 선택해주세요";

    public static void printCorrectAnswer() {
        System.out.println(CORRECT_ANSWER_MENT);
    }

    public static void printNothingCorrect() {
        System.out.println(NOTHING_MENT);
    }

    public static void printOnlyStrike(int strike) {
        System.out.println(strike + STRIKE_MENT);
    }

    public static void printOnlyBall(int ball) {
        System.out.println(ball + BALL_MENT);
    }

    public static void printStrikeAndBall(int strike, int ball) {
        System.out.println(strike + STRIKE_MENT + ball + BALL_MENT);
    }

    public static void printEnd() {
        System.out.println(END_GAME_MENT);
    }

    public static void printInputError() {
        System.out.println(INPUT_ERROR_MENT);
    }
}
