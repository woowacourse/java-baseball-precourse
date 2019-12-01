package domain;

public class OneBaseBall {
	private BaseBallNumber baseBallNumber;
	private Integer baseBallPosition;

	private OneBaseBall(BaseBallNumber baseBallNumber, Integer baseBallPosition) {
		this.baseBallNumber = baseBallNumber;
		this.baseBallPosition = baseBallPosition;
	}

	static OneBaseBall ofInteger(Integer baseBallNumber, Integer baseBallPosition) {
		return new OneBaseBall(new BaseBallNumber(baseBallNumber), baseBallPosition);
	}
}
