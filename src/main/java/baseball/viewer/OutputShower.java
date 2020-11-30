package baseball.viewer;

public class OutputShower {
    /* 상대방에게 재시작 의사를 묻는 메서드 */
    public static void askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /* 숫자를 모두 맞았을 시에 메세지를 보여주는 메서드 */
    public static void showGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /* 숫자를 하나도 맞추지 못하였을 때의 메세지를 보여주는 메서드 */
    public static void showNothing() {
        System.out.println("낫싱");
    }

    /* 현재 스트라이크와 볼 상황을 보여주는 메서드 */
    public static void showBothBallStrike(int ballNumber, int strikeNumber) {
        System.out.printf("%d볼 %d스트라이크\n", ballNumber, strikeNumber);
    }

    public static void showBall(int ballNumber) {
        System.out.printf("%d볼\n", ballNumber);
    }

    public static void showStrike(int strikeNumber) {
        System.out.printf("%d스트라이크\n", strikeNumber);
    }
}
