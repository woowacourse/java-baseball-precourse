package model.ball;

import model.ComparisonResult;
import model.ball.vo.BallNumber;
import model.ball.vo.BallPosition;

public class Baseball {
    private final BallNumber number;
    private final BallPosition position;

    public Baseball(final int number, final int position) {
        this.number = new BallNumber(number);
        this.position = new BallPosition(position);
    }

    public ComparisonResult compare(final Baseball another) {
        if (hasSameNumberAndSamePosition(another)) {
            return ComparisonResult.STRIKE;
        } else if (hasSameNumberAndDifferentPosition(another)) {
            return ComparisonResult.BALL;
        }
        return ComparisonResult.FAIL;
    }

    private boolean hasSameNumberAndSamePosition(final Baseball another) {
        return number.equals(another.number) && position.equals(another.position);
    }

    private boolean hasSameNumberAndDifferentPosition(final Baseball another) {
        return number.equals(another.number) && !position.equals(another.position);
    }
}
