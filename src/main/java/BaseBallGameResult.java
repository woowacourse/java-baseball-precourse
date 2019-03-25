import java.util.List;

public class BaseBallGameResult {
    public static final int BASEBALL_NUMBER_COUNTING_SIZE = 3;
    private int strike = 0;
    private int ball = 0;
    private List<BaseNumber> computerBaseBallNumber;
    private List<BaseNumber> userBaseBallNumber;

    public BaseBallGameResult(List<BaseNumber> userBaseBallNumber, List<BaseNumber> computerBaseBallNumber) {
        this.userBaseBallNumber = userBaseBallNumber;
        this.computerBaseBallNumber = computerBaseBallNumber;
        checkStrike();
        checkBall();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void checkStrike() {
        for(int i = 0; i < BASEBALL_NUMBER_COUNTING_SIZE; i++) {
            if (userBaseBallNumber.get(i).getNumber() == computerBaseBallNumber.get(i).getNumber())
                strike++;
        }
    }

    private void checkBall() {
        for(int i = 0; i < BASEBALL_NUMBER_COUNTING_SIZE; i++) {
            if (computerBaseBallNumber.contains(userBaseBallNumber.get(i))
                    && userBaseBallNumber.get(i).getNumber() != computerBaseBallNumber.get(i).getNumber())
                ball++;
        }
    }
} 
