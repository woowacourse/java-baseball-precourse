package baseball;

public class HintPrinter {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "스트라이크 ";
    private static final String BALL_MESSAGE = "볼 ";

    private HintPrinter() {
    }

    public static void printHint(int ball, int strike) {
        if (ball+strike == 0) {
            printNothing();
        }
        if (ball != 0) {
            printBall(ball);
        }
        if (strike != 0) {
            printStrike(strike);
        }
        System.out.println();
    }

    public static void printNothing() {
        System.out.print(NOTHING_MESSAGE);
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
