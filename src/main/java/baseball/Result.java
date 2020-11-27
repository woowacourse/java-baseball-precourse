package baseball;

public class Result {
    private static final String TERMINATE_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private RandomThreeNumberGenerator randomThreeNumberGenerator;
    private Player player;
    private boolean isTerminated;

    public Result(RandomThreeNumberGenerator randomThreeNumberGenerator, Player player) {
        this.randomThreeNumberGenerator = randomThreeNumberGenerator;
        this.player = player;
        this.isTerminated = false;
    }

    public String getResult() {
        int strikeCount = countStrike();
        int ballCount = countBall();
        if (strikeCount >= 3) {
            this.isTerminated = true;
        }

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

    public boolean isTerminated() {
        return this.isTerminated;
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < this.randomThreeNumberGenerator.getNumbers().size(); i++) {
            for (int j = 0; j < this.player.getNumbers().size(); j++) {
                count += isBall(i, j);
            }
        }
        return count;
    }

    private int isBall(int randomNumberIndex, int playerNumberIndex) {
        if (randomNumberIndex != playerNumberIndex && this.randomThreeNumberGenerator.getNumbers().get(randomNumberIndex) == this.player.getNumbers().get(playerNumberIndex)) {
            return 1;
        }
        return 0;
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < this.randomThreeNumberGenerator.getNumbers().size(); i++) {
            for (int j = i; j < this.player.getNumbers().size(); j++) {
                count += isStrike(i, j);
            }
        }
        return count;
    }

    private int isStrike(int randomNumberIndex, int playerNumberIndex) {
        if (randomNumberIndex == playerNumberIndex && this.randomThreeNumberGenerator.getNumbers().get(randomNumberIndex) == this.player.getNumbers().get(playerNumberIndex)) {
            return 1;
        }
        return 0;
    }
}
