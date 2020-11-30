package baseball;

public class User {
    private static final int MAX_DIGIT = 3;

    private int[] numbers;
    private int ball;
    private int strike;

    public User() {
        numbers = new int[MAX_DIGIT];
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setBall(int n) {
        ball = n;
    }

    public void setStrike(int n) {
        strike = n;
    }

    public void setNumbers(int num) {
        char[] numString = Integer.toString(num).toCharArray();
        for (int i = 0; i < MAX_DIGIT; i++) {
            numbers[i] = numString[i] - '0';
        }
    }
}
