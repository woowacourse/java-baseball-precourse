package baseball.domain;

public class Computer {
    private static RandomGenerator randomGenerator;
    private static Computer instance = new Computer();
    private static int[] answer;
    private final int BALL = 0;
    private final int STRIKE = 1;

    private Computer() {
        randomGenerator = RandomGenerator.getInstance();
        answer = randomGenerator.getAnswer();
    }

    public static Computer getInstance() {
        if (instance == null) {
            return new Computer();
        }
        getNewAnswer();
        return instance;
    }

    private static void getNewAnswer() {
        randomGenerator.reGenerate();
        answer = randomGenerator.getAnswer();
    }

    public int[] generateHint(int[] playerNumber) {
        int[] hint = new int[2];
        int strikeCount = countStrike(playerNumber);
        int ballCount = countBall(playerNumber);

        hint[STRIKE] = strikeCount;
        hint[BALL] = ballCount;

        return hint;
    }

    private int countBall(int[] playerNumber) {
        int count = 0;
        if (playerNumber[0] == answer[1] || playerNumber[0] == answer[2]) {
            count++;
        }
        if (playerNumber[1] == answer[0] || playerNumber[1] == answer[2]) {
            count++;
        }
        if (playerNumber[2] == answer[0] || playerNumber[2] == answer[1]) {
            count++;
        }

        return count;
    }

    private int countStrike(int[] playerNumber) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (playerNumber[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
