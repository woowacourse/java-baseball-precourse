package baseball;

public class OutputChannel {
    private static final String QUESTION_FOR_BASEBALL_NUMBER = "숫자를 입력해주세요 : ";
    private static final String CONGRATULATION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String QUESTION_FOR_RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String SPACE = " ";
    private static final String ENTER = "\n";

    private OutputChannel() {
    }

    public static void printBaseBallNumberQuestion() {
        System.out.print(QUESTION_FOR_BASEBALL_NUMBER);
    }

    public static void printCongratulations() {
        System.out.println(CONGRATULATION_MESSAGE);
    }

    public static void printReGameQuestion() {
        System.out.println(QUESTION_FOR_RE_GAME);
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
            System.out.println(ballCount + BALL);
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
