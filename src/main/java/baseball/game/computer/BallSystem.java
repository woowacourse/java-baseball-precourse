package baseball.game.computer;

public class BallSystem {
    private final Generator generator;
    private final Calculator calculator;

    public BallSystem(Generator generator, Calculator calculator) {
        this.generator = generator;
        this.calculator = calculator;
    }
}
