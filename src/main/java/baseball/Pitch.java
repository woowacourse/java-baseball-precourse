package baseball;

public class Pitch {
    private int inputNumber;
    private int targetNumber;
    private Calculator calculator;

    public Pitch(int inputNumber, int targetNumber) {
        this.inputNumber = inputNumber;
        this.targetNumber = targetNumber;
        this.calculator = new Calculator(inputNumber, targetNumber);
    }

    public void printHint() {
        int strikeCount = calculator.countStrike();
        int ballCount = calculator.countBall();
        OutputChannel.printHint(strikeCount, ballCount);
    }

    public boolean isCorrect() {
        return inputNumber == targetNumber;
    }
}

