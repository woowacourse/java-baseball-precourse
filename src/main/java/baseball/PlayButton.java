package baseball;

import utils.InputValidator;

public class PlayButton {
    public static final int MAX = 2;
    public static final int MIN = 1;
    public static final int LEN = 1;

    private static final String PLAY_AGAIN_BUTTON = "1";
    private static final String PLAY_END_BUTTON = "2";

    private final String playAgainButton;

    public PlayButton(String userInput) throws IllegalArgumentException {
        InputValidator.checkValidPlayAgainBtn(userInput);

        this.playAgainButton = userInput;
    }

    public boolean playAgain() {
        return playAgainButton.equals(PLAY_AGAIN_BUTTON);
    }
}
