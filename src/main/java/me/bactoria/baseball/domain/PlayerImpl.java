package me.bactoria.baseball.domain;

import me.bactoria.baseball.Constant;
import me.bactoria.baseball.utils.IntegerUtils;

public class PlayerImpl implements Player {

	private int playerNumber;

	public PlayerImpl() {
	}

	@Override
	public void setPlayerNumber(int playerNumber) {
		if (!IntegerUtils.isNthDigitsNumber(playerNumber, Constant.NUMBER_OF_DIGITS)){
			throw new IllegalArgumentException("숫자는 " + Constant.NUMBER_OF_DIGITS + "자리 정수이어야 합니다.");
		}
		if (!IntegerUtils.isEachDigitUnique(playerNumber)) {
			throw new IllegalArgumentException("각 자리는 다른 수로 이루어져야 합니다.");
		}
		if (IntegerUtils.containZero(playerNumber)) {
			throw new IllegalArgumentException("숫자는 0을 포함할 수 없습니다.");
		}
		this.playerNumber = playerNumber;
	}

	@Override
	public int getPlayerNumber() {
		return playerNumber;
	}
}
