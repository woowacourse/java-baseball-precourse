package baseball.resource.rule;

import baseball.exception.InputOutOfOptionsMessageException;

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
        for (PlayOption playOption : PlayOption.values()) {
            if (playOption.option == option) {
                return playOption;
            }
        }
        throw new InputOutOfOptionsMessageException();
    }

}
