package baseball;

public class Ball {
    private final Integer number;

    public Ball(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < 1 || 9 < number) {
            throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball;
        if (obj instanceof Ball) {
            ball = (Ball) obj;
        } else {
            throw new ClassCastException("Ball 객체 끼리만 비교가 가능합니다.");
        }
        return this.number.equals(ball.number);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + ((number == null) ? 0 : number.hashCode());

        return result;
    }
}