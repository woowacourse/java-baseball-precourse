package baseball.view;

public class FixedInputStrategy implements InputStrategy {

    private String ballNubmer;

    public FixedInputStrategy(String ballNubmer) {
        this.ballNubmer = ballNubmer;
    }

    @Override
    public String getInput() {
        return null;
    }
}
