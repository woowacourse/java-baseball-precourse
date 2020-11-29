package baseball;

public class OutputChannel {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";

    private OutputChannel() {
    }

    public static void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            printNothing();
            return;
        }
        printSomething(strikeCount, ballCount);
    }

    private static void printNothing() {
        System.out.println(NOTHING);
    }

    private static void printSomething(int strikeCount, int ballCount) {
        if (ballCount > 0) {
            System.out.println(ballCount + BALL);;
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.print(SPACE);
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + STRIKE);
        }
        System.out.print(ENTER);
    }
}
