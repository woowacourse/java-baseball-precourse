package baseball;

public class Judge {
    public static final int RECORD_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private static final int STRIKE_TO_WIN = 3;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String CORRECT_ALL = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static int strike;
    static int ball;


    public void compareRecords(int[] humanPlayerRecords, int[] computerPlayerRecords) {
        strike = countStrike(humanPlayerRecords, computerPlayerRecords);
        ball = countBall(humanPlayerRecords, computerPlayerRecords);
        if (!isPlayerCorrectAll()) {
            printHint();
            return;
        }
        System.out.println(STRIKE_TO_WIN+CORRECT_ALL);
    }

    private void printHint() {
        if (ball != 0) {
            System.out.printf("%d" + BALL + " ", ball);
        }
        if (strike != 0) {
            System.out.printf("%d" + STRIKE, strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.printf(NOTHING);
        }
        System.out.println();
    }

    private int countBall(int[] humanPlayerRecords, int[] computerPlayerRecords) {
        int countSameDigit = 0;
        for (int i = 0; i < RECORD_LENGTH; i++) {
            if (isSameDigitInRecords(humanPlayerRecords, computerPlayerRecords[i])) {
                countSameDigit++;
            }
        }
        return countSameDigit - strike;
    }

    private int countStrike(int[] humanPlayerRecords, int[] computerPlayerRecords) {
        int strikeCounter = 0;
        for (int i = 0; i < RECORD_LENGTH; i++) {
            if (humanPlayerRecords[i] == computerPlayerRecords[i]) {
                strikeCounter++;
            }
        }
        return strikeCounter;
    }

    private boolean isSameDigitInRecords(int[] records, int newDigit) {
        for (int i = 0; i < records.length; i++) {
            if (newDigit == records[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean isPlayerCorrectAll() {
        return strike == STRIKE_TO_WIN;
    }
}
