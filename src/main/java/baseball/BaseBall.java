package baseball;

import constant.SystemMessage;


public class BaseBall {
    private Referee referee;
    private Player player;
    private RandomNumberGenerator randomNumberGenerator;

    public BaseBall(Referee computer, Player player, RandomNumberGenerator randomNumberGenerator) {
        this.referee = computer;
        this.player = player;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playGame() {
        int randomNumber = randomNumberGenerator.generateRandomNumber();
        int predict = SystemMessage.ZERO;
        do {
            predict = player.predictNumber();
            referee.calculateBallCount(randomNumber, predict);
        } while (!referee.canFinish());
        System.out.printf("%s\n", SystemMessage.END_GAME_MESSAGE);
    }

    public boolean decideNextGame() {
        return player.decideGoOrStop();
    }

}
