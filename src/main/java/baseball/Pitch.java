package baseball;

public class Pitch {
    private final String NOTHING = "낫싱";
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private int targetNumber;

    public Pitch(int targetNumber) {
        this.targetNumber = targetNumber;
    }


    private String stringifyHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0){
            return NOTHING;
        }
        String message = "";
        if (ballCount > 0) {
            message = Integer.toString(ballCount) + BALL;
        }
        if (strikeCount > 0) {
            message = message + Integer.toString(strikeCount) + STRIKE;
        }
        return message;
    }

    public String getHint(int inputNumber) {
        Calculator calculator = new Calculator(inputNumber, targetNumber);
        int strikeCount = calculator.countStrike();
        int ballCount = calculator.countBall();
        return stringifyHint(strikeCount, ballCount);
    }

    public boolean isCorrect(int guess) {
        return guess == targetNumber;
    }
}

