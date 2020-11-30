package baseball;

public class Printer {
    private static final String START_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼";
    private static final String NOTHING = "낫싱";
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PROGRESS_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.print(START_MESSAGE);
    }

    public void printHint(final int ballCnt, final int strikeCnt) {
        if ((ballCnt == 0) && (strikeCnt == 0)) {
            System.out.println(NOTHING);
        } else if ((ballCnt > 0) && (strikeCnt == 0)) {
            System.out.printf(BALL + "\n", ballCnt);
        } else if ((ballCnt == 0) && (strikeCnt > 0)) {
            System.out.printf(STRIKE + "\n", strikeCnt);
        } else {
            System.out.printf(BALL + " " + STRIKE + "\n", ballCnt, strikeCnt);
        }
    }

    public void printFinishMessage() {
        System.out.println(FINISH_MESSAGE);
    }

    public void printProgressMessage() {
        System.out.println(PROGRESS_MESSAGE);
    }
}