package utils.validator;

import static baseball.domain.Game.GAME_END;
import static baseball.domain.Game.GAME_START;

public class RestartValidator implements Validator {
    @Override
    public boolean execute(String input) {
        if (input.equals(GAME_START) || input.equals(GAME_END)) {
            return true;
        }
        
        return false;
    }
}
