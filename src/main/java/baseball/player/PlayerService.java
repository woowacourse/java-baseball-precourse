package baseball.player;

import baseball.utils.RandomDigitsGenerator;

public class PlayerService {

    private Computer computer;
    private User user;
    private int strikeScore = 0;
    private int ballScore = 0;

    public PlayerService () {
        computer = new Computer();
        user = new User();
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

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }
}
