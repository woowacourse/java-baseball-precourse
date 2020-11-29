package baseball;

public class Result {
    private static final String COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private RandomNumbers randomNumbers;
    private Player player;
    private boolean isTerminated;

    public Result(RandomNumbers randomNumbers, Player player) {
        this.randomNumbers = randomNumbers;
        this.player = player;
        this.isTerminated = false;
    }

    private String result() {
        int strikeCount = countStrike();
        int ballCount = countBall();
        setIsTerminated(strikeCount);

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        if (strikeCount == 0) {
            return ballCount + "볼";
        }

        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    private void setIsTerminated(int strikeCount) {
        if (strikeCount >= 3) {
            this.isTerminated = true;
        }
    }

    private int countBall() {
        int count = 0;
        int randomNumberSize = this.randomNumbers.getNumberSize();
        int playerNumberSize = this.player.getNumberSize();
        for (int i = 0; i < randomNumberSize; i++) {
            for (int j = 0; j < playerNumberSize; j++) {
                count += isBall(i, j);
            }
        }
        return count;
    }

    private int isBall(int randomNumberIndex, int playerNumberIndex) {
        if (randomNumberIndex != playerNumberIndex && this.randomNumbers.getNumber(randomNumberIndex) == this.player.getNumber(playerNumberIndex)) {
            return 1;
        }
        return 0;
    }

    private int countStrike() {
        int count = 0;
        int randomNumberSize = this.randomNumbers.getNumberSize();
        int playerNumberSize = this.player.getNumberSize();
        for (int i = 0; i < randomNumberSize; i++) {
            for (int j = i; j < playerNumberSize; j++) {
                count += isStrike(i, j);
            }
        }
        return count;
    }

    private int isStrike(int randomNumberIndex, int playerNumberIndex) {
        if (randomNumberIndex == playerNumberIndex && this.randomNumbers.getNumber(randomNumberIndex) == this.player.getNumber(playerNumberIndex)) {
            return 1;
        }
        return 0;
    }

    public boolean terminated() {
        if (this.isTerminated) {
            System.out.println(COMPLETE_MESSAGE);
        }
        return this.isTerminated;
    }

    @Override
    public String toString() {
        return result();
    }
}
