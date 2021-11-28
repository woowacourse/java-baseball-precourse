package baseball.domain;

public class Ball {

    private int number;

    public Ball(int number) throws IllegalArgumentException {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("잘못 된 숫자 범위 입니다");
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return "Ball{" +
            "number=" + number +
            '}';
    }
}
