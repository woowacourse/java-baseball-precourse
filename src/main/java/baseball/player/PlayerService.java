package baseball.player;

import baseball.utils.RandomDigitsGenerator;

import java.util.List;

public class PlayerService {

    private Player computer;
    private Player user;
    private int strikeScore = 0;
    private int ballScore = 0;

    private PlayerService () {
        computer = new Player();
        user = new Player();
    }

    private static class InnerInstanceClazz {
        private static final PlayerService instance = new PlayerService();
    }

    public static PlayerService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void computeGameScore() {
        setZeroScore();

        for(int i = 0; i < RandomDigitsGenerator.RANDOM_DIGIT_COUNT; ++i) {
            Integer userDigit = user.getDigit(i);

            if(computer.isSameDigit(userDigit, i)) {
                strikeScore += 1;
            }
            else if(computer.hasDigit(userDigit)) {
                ballScore += 1;
            }
        }
    }

    public void setZeroScore() {
        strikeScore = 0;
        ballScore = 0;
    }

    public void setUserGameInputDigits(List<Integer> digits) {
        user.setDigits(digits);
    }

    public void setComputerGameRandomDigits() {
        computer.setDigits(RandomDigitsGenerator.createRandomDigits());
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }
}
