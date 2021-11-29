package model.classes;

import static model.constants.ConstantsForGame.*;

import model.constants.BallStatus;
import model.constants.GameMode;
import model.constants.StrikeStatus;

public class CountingStatus {
	private BallStatus ballStatus;
	private StrikeStatus strikeStatus;

	public CountingStatus(BallStatus ballStatus, StrikeStatus strikeStatus) {
		this.ballStatus = ballStatus;
		this.strikeStatus = strikeStatus;
	}
	public CountingStatus() {
		this.ballStatus = BallStatus.zero;
		this.strikeStatus = StrikeStatus.zero;
	}

	public void setBallStatus(BallStatus ballStatus) {
		this.ballStatus = ballStatus;
	}
	public void setStrikeStatus(StrikeStatus strikeStatus) {
		this.strikeStatus = strikeStatus;
	}

	@Override
	public String toString() {
		return toStringFromCountingStatus();
	}

	private String toStringFromCountingStatus() {
		if (ballStatus == BallStatus.zero && strikeStatus == StrikeStatus.zero) {
			return NOTHING_STATMENT;
		}
		return "" +
			toIntByBallStatus() +
			BALL_STATEMENT +
			" " +
			toIntByStrikeStatus() +
			STRIKE_STATEMENT;
	}

	private int toIntByBallStatus() {
		if (ballStatus == BallStatus.zero) {
			return 0;
		} else if (ballStatus == BallStatus.one) {
			return 1;
		} else if (ballStatus == BallStatus.two) {
			return 2;
		} else if (ballStatus == BallStatus.three) {
			return 3;
		} else if (ballStatus == BallStatus.four) {
			return 4;
		}
		return 0;
	}

	private int toIntByStrikeStatus() {
		if (strikeStatus == StrikeStatus.zero) {
			return 0;
		} else if (strikeStatus == StrikeStatus.one) {
			return 1;
		} else if (strikeStatus == StrikeStatus.two) {
			return 2;
		} else if (strikeStatus == StrikeStatus.three) {
			return 3;
		}
		return 0;
	}
}
