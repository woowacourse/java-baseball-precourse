package baseball;

public class Alert {
    private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
    private static final String ALL_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final int ZERO = 0;

    public static void enterNumber() {
        System.out.print(NUMBER_INPUT);
    }

    public static void finishGame() {
        System.out.println(ALL_CORRECT);
    }

    public static void askToRestart() {
        System.out.println(RESTART);
    }

    public static void markScore(int ball, int strike) {
        if (ball == ZERO && strike == ZERO) {
           sayNothing();
           return;
        }
        if (ball == ZERO) {
            sayOnlyStrike(strike);
            return;
        }
        if (strike == ZERO) {
            sayOnlyBall(ball);
            return;
        }

        System.out.println(ball + BALL + " " + strike + STRIKE);
    }


    private static void sayOnlyBall(int ball) {
        System.out.println(ball + BALL);
    }

    private static void sayOnlyStrike(int strike) {
        System.out.println(strike + STRIKE);
    }

    private static void sayNothing() {
        System.out.println(NOTHING);
    }
}
