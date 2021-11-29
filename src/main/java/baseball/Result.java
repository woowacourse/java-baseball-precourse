package baseball;

public class Result {

    private final String randomNumber;
    private String inputNumber;
    private int ball;
    private int strike;

    public Result(String randomNumber) {
        this.randomNumber = randomNumber;
        this.ball = 0;
        this.strike = 0;
    }

    public void makeResult(String input) {
        this.inputNumber = input;
        this.ball = 0;
        this.strike = 0;
        countBall();
        countStrike();
    }

    private void countBall() {
        String[] inputNumbers = inputNumber.split("");
        for (int i = 0; i < inputNumbers.length; i++) {
            String target = inputNumbers[i];
            if (randomNumber.contains(target) && randomNumber.indexOf(target) != i) {
                ball++;
            }
        }
    }

    private void countStrike() {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) == randomNumber.charAt(i)) {
                this.strike++;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
