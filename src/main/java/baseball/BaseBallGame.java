package baseball;

public class BaseBallGame {
    private final int DIGIT_LENGTH;
    private Computer computer;

    public BaseBallGame(int digitLength) {
        this.DIGIT_LENGTH = digitLength;
    }

    public void run() {
        computer = new Computer(DIGIT_LENGTH);

        start();
    }

    private void start() {
        computer.generateDigits();

    }
}
