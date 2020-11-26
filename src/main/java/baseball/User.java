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
        for (int i = 0; i < MAX_DIGIT; i++) {
            numbers[i] = num / 100;
            num = (num % 100) * 10;
        }
    }

    public void printInfoForTest() {
        System.out.print("3자리 수 : ");
        for (int i = 0; i < MAX_DIGIT; i++) {
            System.out.print(numbers[i]);
        }
        System.out.println();
        System.out.println("볼 : " + ball);
        System.out.println("스트라이크 : " + strike);
    }
}
