package view;

public class OutputView {
    private static final String ANNOUNCE_BALL_CNT = "볼";
    private static final String ANNOUNCE_STRIKE_CNT = "스트라이크";
    private static final String SEPARATOR_BALL_STRIKE = " ";
    private static final String ANNOUNCE_NOTHING = "낫싱";
    private static final String SEPARATOR_ROUND = "\n";
    private static final String ANNOUNCE_ALL_CORRECT = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private OutputView(){}

    public static void printScore(int strikeCnt, int ballCnt){
        if(ballCnt == 0 && strikeCnt == 0){
            printMsg(ANNOUNCE_NOTHING);
            printMsg(SEPARATOR_ROUND);
            return;
        }

        if(ballCnt != 0) {
            printMsg(ballCnt);
            printMsg(ANNOUNCE_BALL_CNT);
            printMsg(SEPARATOR_BALL_STRIKE);
        }

        if(strikeCnt != 0){
            printMsg(strikeCnt);
            printMsg(ANNOUNCE_STRIKE_CNT);
        }

        printMsg(SEPARATOR_ROUND);
    }

    public static void announceAllCorrect(){
        printMsg(ANNOUNCE_ALL_CORRECT);
        printMsg(SEPARATOR_ROUND);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
