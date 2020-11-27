package baseball.view;

public class GameView {

    private static StringBuilder printBallStrike = new StringBuilder();
    private static final int ZERO = 0;

    public static void printPleaseInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameResult(int ball, int strike) {
        printBallStrike.setLength(ZERO);    // reset

        appendBall(ball);
        appendSpace();
        appendStrike(strike);

        if (printBallStrike.length() == ZERO) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(printBallStrike);
    }

    public static void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void appendBall(int ball) {
        if (ball > ZERO) {
            printBallStrike.append(ball);
            printBallStrike.append("볼");
        }
    }

    private static void appendSpace() {
        if (printBallStrike.length() > ZERO) {
            printBallStrike.append(" ");
        }
    }

    private static void appendStrike(int strike) {
        if (strike > ZERO) {
            printBallStrike.append(strike);
            printBallStrike.append("스트라이크");
        }
    }
}
