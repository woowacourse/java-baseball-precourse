package baseball;

import java.util.Objects;

public class BaseBall {
    private final BaseBallPosition baseBallPosition;
    private final BaseBallNumber baseBallNumber;

    public BaseBall(int position, int number) {
        this.baseBallPosition = new BaseBallPosition(position);
        this.baseBallNumber = new BaseBallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseBall = (BaseBall) o;
        return Objects.equals(baseBallPosition, baseBall.baseBallPosition) &&
                Objects.equals(baseBallNumber, baseBall.baseBallNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseBallPosition, baseBallNumber);
    }
}
