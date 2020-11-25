package baseball;

public class Ball {
    private int number;

    public Ball(int number) {
        checkArgumentBoundary(number);
        this.number = number;
    }

    private void checkArgumentBoundary(int number) {
        if (number < 1 || 9 < number) {
            throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
        }
    }
}