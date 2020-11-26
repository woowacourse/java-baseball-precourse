package baseball.view;

public class OutputView {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String SPACE = " ";
    private static final String NOTHING = "낫싱";

    public static void printHint(int strikeNumber, int ballNumber) {
        if (strikeNumber == 0 && ballNumber == 0) {
            System.out.println(NOTHING);
            return;
        }

        if (ballNumber > 0) {
            System.out.print(ballNumber + BALL + SPACE);
        }

        if (strikeNumber > 0) {
            System.out.print(strikeNumber + STRIKE);
        }
        System.out.println();
    }
}
