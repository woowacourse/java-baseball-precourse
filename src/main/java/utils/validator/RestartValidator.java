package utils.validator;

import baseball.domain.Game;

public class RestartValidator implements Validator {
    @Override
    public boolean execute(String input) {
        if (input.equals(Game.GAME_START) || input.equals(Game.GAME_END)) {
            return true;
        }

        return false;
    }
}
