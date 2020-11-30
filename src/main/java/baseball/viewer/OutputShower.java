package baseball.viewer;

import baseball.domain.User;

public class OutputShower {
    static final int END_GAME = 3;
    static final int NOTHING = 0;

    /**
     * 사용자의 게임 상태를 받아 상태를 판단하여 사용자에게 보여주는 메서드
     * @param user 사용자의 게임 상태를 가지고 있는 인스턴스
     */
    public static void outputPrint(User user) {
        int ballNumber = user.getBallNumber();
        int strikeNumber = user.getStrikeNumber();
        if (strikeNumber == END_GAME) {
            showGameOver();
            return;
        }
        if ((strikeNumber == NOTHING) && (ballNumber) == NOTHING) {
            showNothing();
            return;
        }
        showSitutation(strikeNumber, ballNumber);
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

    /* 상대방에게 재시작 의사를 묻는 메서드 */
    public static void askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }
}
