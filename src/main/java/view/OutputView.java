package view;

public class OutputView {
    private static final String ANNOUNCE_BALL_CNT = "볼";
    private static final String ANNOUNCE_STRIKE_CNT = "스트라이크";
    private static final String ANNOUNCE_NOTHING = "낫싱";

    public static void printScore(int strikeCnt, int ballCnt){
        if(ballCnt == 0 && strikeCnt == 0){
            System.out.print(ANNOUNCE_NOTHING);
            return;
        }

        if(ballCnt != 0) {
            System.out.print(ballCnt);
            System.out.print(ANNOUNCE_BALL_CNT);
        }

        if(strikeCnt != 0){
            System.out.print(strikeCnt);
            System.out.print(ANNOUNCE_STRIKE_CNT);
        }
    }
}
