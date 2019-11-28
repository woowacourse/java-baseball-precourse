package baseball.generator;

public class ManualBallGenerator extends BallGenerator {


    @Override
    public int getNumber(int number) {
        return ballNumbers.get(number - PADDING);
    }
}
