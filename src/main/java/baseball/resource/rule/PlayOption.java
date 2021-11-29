package baseball.resource.rule;

import baseball.exception.InputOutOfOptionsMessageException;

import java.util.Arrays;

public enum PlayOption {

    PLAY(1, true), STOP(2, false);

    private final int option;
    private final boolean playable;

    PlayOption(int option, boolean playable) {
        this.option = option;
        this.playable = playable;
    }

    public int getOption() {
        return this.option;
    }

    public boolean isPlayable() {
        return this.playable;
    }

    public static PlayOption of(int option) {
        return Arrays.stream(PlayOption.values())
                .filter(playOption -> playOption.option == option)
                .findAny()
                .orElseThrow(InputOutOfOptionsMessageException::new);
    }

}
