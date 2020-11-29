package utils.validator;

import baseball.domain.Game;

public class RestartValidator implements Validator {
    @Override
    public void execute(String input) {
        if (!(input.equals(Game.GAME_START) || input.equals(Game.GAME_END))) {
            new IllegalArgumentException();
        }
    }
}
