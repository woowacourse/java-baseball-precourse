package me.bactoria.baseball.domain;

import me.bactoria.baseball.Constant;

import java.util.Arrays;

public enum State {

	PLAY_CONTINUE(Constant.PLAY_CONTINUE_NUMBER),
	EXIT(Constant.EXIT_GAME_NUMBER);
	private final int value;

	private State(int value) {
		this.value = value;
	}

	public static State findState(int i) {
		return Arrays.stream(State.values())
				        .filter(x -> x.getValue() == i)
				        .findAny()
				        .orElseThrow(() -> new IllegalArgumentException("잘못된 입력 값 입니다. :: " + i));
	}

	public int getValue() {
		return value;
	}
}
