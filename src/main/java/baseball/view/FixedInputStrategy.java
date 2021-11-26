package baseball.view;

public class FixedInputStrategy implements InputStrategy {

    private final String ballNumber;

    public FixedInputStrategy(String ballNumber) {
        this.ballNumber = ballNumber;
    }

    @Override
    public String getInput() {
        return ballNumber;
    }
}
