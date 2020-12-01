package utils.validator;


import baseball.domain.GameType;

public class RestartValidator implements Validator {
    @Override
    public void execute(String input) {
        if (!GameType.START.equals(input) && !GameType.END.equals(input)) {
            throw new IllegalArgumentException();
        }
    }
}
