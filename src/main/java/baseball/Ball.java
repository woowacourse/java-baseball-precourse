package baseball;

public class Ball {

    private final Integer number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
    }

    public Ball(char c) {
        // TODO 문자열이나 공백 등 int 아니면?
        this(Integer.parseInt(String.valueOf(c)));
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    private void validateRange(int number) {
        if (number < 1 || 9 < number) {
            throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다. number:" + number);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Ball ball;
        if (obj instanceof Ball) {
            ball = (Ball) obj;
        } else {
            throw new ClassCastException(this.getClass().getName() + " 객체 끼리만 비교가 가능합니다.");
        }
        return this.number.equals(ball.number);
    }

    @Override
    public int hashCode() {
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }
}