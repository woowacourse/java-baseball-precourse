package baseball.resource.rule;

import java.util.Arrays;

import baseball.exception.InputOutOfOptionsMessageException;

public enum PlayOption {

	RESTART(1, true), STOP(2, false);

	private final int option;
	private final boolean playable;

	PlayOption(int option, boolean playable) {
		this.option = option;
		this.playable = playable;
	}

	public static PlayOption of(int option) {
		return Arrays.stream(PlayOption.values())
				.filter(playOption -> playOption.option == option)
				.findAny()
				.orElseThrow(InputOutOfOptionsMessageException::new);
	}

	public static int getRestartOption() {
		return RESTART.option;
	}

	public static int getStopOption() {
		return STOP.option;
	}

	public boolean isPlayable() {
		return this.playable;
	}

}
