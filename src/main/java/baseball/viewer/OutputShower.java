package baseball.viewer;

public class OutputShower {
    private static final String askRestartMessage =  "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String gameOverMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String nothingMessage = "낫싱";
    private static final String bothBallStrikeMessage = "%d볼 %d스트라이크\n";
    private static final String ballMessage = "%d볼\n";
    private static final String strikeMessage = "%d스트라이크\n";

    /* 상대방에게 재시작 의사를 묻는 메서드 */
    public static void askRestart() {
        System.out.println(askRestartMessage);
    }

    /* 숫자를 모두 맞았을 시에 메세지를 보여주는 메서드 */
    public static void showGameOver() {
        System.out.println(gameOverMessage);
    }

    /* 숫자를 하나도 맞추지 못하였을 때의 메세지를 보여주는 메서드 */
    public static void showNothing() {
        System.out.println(nothingMessage);
    }

    /**
     * 현재 스트라이크와 볼 상황을 보여주는 메서드
     *
     * @param ballNumber 현재 유저가 채점 받은 볼의 갯수
     * @param strikeNumber 현재 유저가 채점 받은 스트라이크 갯수
     */
    public static void showBothBallStrike(int ballNumber, int strikeNumber) {
        System.out.printf(bothBallStrikeMessage, ballNumber, strikeNumber);
    }

    /**
     * 현재 볼만 가지고 있을 때, 상황을 보여주는 메서드
     *
     * @param ballNumber 현재 유저가 채점 받은 볼의 갯수
     */
    public static void showBall(int ballNumber) {
        System.out.printf(ballMessage, ballNumber);
    }

    /**
     * 현재 스트라이크만 가지고 있을 때, 상황을 보여주는 메서드
     *
     * @param strikeNumber 현재 유저가 채점 받은 스트라이크의 갯수
     */
    public static void showStrike(int strikeNumber) {
        System.out.printf(strikeMessage, strikeNumber);
    }
}
