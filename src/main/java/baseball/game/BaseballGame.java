package baseball.game;

public class BaseballGame implements Runnable {

    private final BaseBallGenerator baseBallGenerator;

    public BaseballGame(BaseBallGenerator baseBallGenerator) {
        this.baseBallGenerator = baseBallGenerator;
    }

    @Override
    public void run() {
        BaseBall computerBaseball = this.baseBallGenerator.generateBaseBall();

    }
}
