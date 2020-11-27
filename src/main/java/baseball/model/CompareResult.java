package baseball.model;

public class CompareResult {
    public static int ball;
    public static int strike;

    private static final int RESET = 0;
    private static final int THREE_STRIKE = 3;

    public static void resetResult() {
        ball = RESET;
        strike = RESET;
    }

    public static boolean isThreeStrike(){
        if (strike == THREE_STRIKE) {
            return true;
        }

        return false;
    }
}
