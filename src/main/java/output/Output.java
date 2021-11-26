package output;

public class Output {
    private static final int UPPER_BOUND = 3;
    private static final int LOWER_BOUND = 0;
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String NOTHTING_STRING = "낫싱";
    private static final String ENTER = "\n";
    private static final String FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SELECT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void pleaseInput() {
        printMessage(INPUT_MESSAGE);
    }

    public static void printResult(int ball, int strike) {
        printBall(ball);
        printStrike(strike);
        printNothing(ball, strike);
        printEnter();
        isFinish(strike);
    }

    public static void printEnter() {
        printMessage(ENTER);
    }

    public static void printBall(int ball) {
        if (ball != LOWER_BOUND)
            printMessage(ball + BALL_STRING + " ");
    }

    public static void printStrike(int strike) {
        if (strike != LOWER_BOUND)
            printMessage(strike + STRIKE_STRING);
    }

    public static void printNothing(int ball, int strike) {
        if (ball == LOWER_BOUND && strike == LOWER_BOUND)
            printMessage(NOTHTING_STRING);
    }

    public static void isFinish(int strike) {
        if (strike == UPPER_BOUND) {
            printFinish();
            printEnter();
            printSelect();
            printEnter();
        }
    }

    public static void printSelect() {
        printMessage(SELECT);
    }

    public static void printFinish() {
        printMessage(FINISH);
    }

}
