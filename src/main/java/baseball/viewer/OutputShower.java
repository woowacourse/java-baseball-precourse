package baseball.viewer;

public class OutputShower {
    static final int ENDGAME = 3;
    static final int NOTHING = 0;

    public static void outputPrint(int strikeNumber, int ballNumber) {
        if (strikeNumber == ENDGAME) {
            showGameOver();
            return;
        }

        if ((strikeNumber == NOTHING) && (ballNumber) == NOTHING) {
            showNothing();
            return;
        }

        showSitutation(strikeNumber, ballNumber);
        return;
    }

    private static void showGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private static void showNothing() {
        System.out.println("낫띵");
    }

    private static void showSitutation(int strikeNumber, int ballNumber) {
        System.out.printf("%d볼 %d스트라이크\n", ballNumber, strikeNumber);
    }

    public static void askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }
}
