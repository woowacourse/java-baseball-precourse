package baseball;

public class User {
    private static final int MAX_DIGIT = 3;

    private int[] numbers;

    public User() {
        numbers = new int[MAX_DIGIT];
    }

    public void setNumbers(int num) {
        for (int i = 0; i < MAX_DIGIT; i++) {
            numbers[i] = num / 100;
            num *= 10;
        }
    }
}
