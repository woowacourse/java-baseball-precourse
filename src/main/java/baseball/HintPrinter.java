package baseball;

public class HintPrinter {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "스트라이크 ";
    private static final String BALL_MESSAGE = "볼 ";

    private HintPrinter() {
    }

    public static void printHint(int answer, int guess) {
        int[] hint = HintGenerator.getHint(answer, guess);
        int ball = hint[0];
        int strike = hint[1];
        if (ball+strike == 0) {
            printNothing();
        }
        printBall(ball);
        printStrike(strike);
    }

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printBall(int ball) {
        String ballMessage = Integer.toString(ball) + BALL_MESSAGE;
        System.out.print(ballMessage);
    }

    public static void printStrike(int strike) {
        String strikeMessage = Integer.toString(strike) + STRIKE_MESSAGE;
        System.out.print(strikeMessage);
    }
}
