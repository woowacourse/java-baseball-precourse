package domain;

import lombok.Getter;

@Getter
public class OneBaseBall {
	private BaseBallNumber baseBallNumber;
	private Integer baseBallPosition;

	private OneBaseBall(BaseBallNumber baseBallNumber, Integer baseBallPosition) {
		this.baseBallNumber = baseBallNumber;
		this.baseBallPosition = baseBallPosition;
	}

	public static OneBaseBall ofInteger(Integer baseBallNumber, Integer baseBallPosition) {
		return new OneBaseBall(BaseBallNumber.of(baseBallNumber), baseBallPosition);
	}

	public boolean equalStrike(OneBaseBall otherBaseBall) {
		return this.baseBallNumber.equals(otherBaseBall.baseBallNumber)
			&& this.baseBallPosition.equals(otherBaseBall.getBaseBallPosition());
	}

	public boolean equalBall(OneBaseBall otherBaseBall) {
		return this.baseBallNumber.equals(otherBaseBall.baseBallNumber)
			&& !this.baseBallPosition.equals(otherBaseBall.getBaseBallPosition());
	}
}
