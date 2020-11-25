package view;

public class OutputView {
    private static final String ANNOUNCE_BALL_CNT = "볼";
    private static final String ANNOUNCE_STRIKE_CNT = "스트라이크";
    private static final String SEPARATOR_BALL_STRIKE = " ";
    private static final String ANNOUNCE_NOTHING = "낫싱";
    private static final String SEPARATOR_ROUND = "\n";
    private static final String ANNOUNCE_ALL_CORRECT = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int NUM_DIGIT = 3;

    public static void printScore(int strikeCnt, int ballCnt){
        if(ballCnt == 0 && strikeCnt == 0){
            System.out.print(ANNOUNCE_NOTHING);
            System.out.print(SEPARATOR_ROUND);
            return;
        }

        if(ballCnt != 0) {
            System.out.print(ballCnt);
            System.out.print(ANNOUNCE_BALL_CNT);
            System.out.print(SEPARATOR_BALL_STRIKE);
        }

        if(strikeCnt != 0){
            System.out.print(strikeCnt);
            System.out.print(ANNOUNCE_STRIKE_CNT);
        }

        System.out.print(SEPARATOR_ROUND);
    }

    public static void announceAllCorrect(){
        System.out.println(ANNOUNCE_ALL_CORRECT);
    }
}
