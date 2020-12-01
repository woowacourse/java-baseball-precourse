package utils.validator;


import baseball.domain.GameType;

public class RestartValidator implements Validator {
    @Override
    public void execute(String input) {
        if (!input.equals(GameType.START.click()) && !input.equals(GameType.END.click())) {
            throw new IllegalArgumentException();
        }
    }
}
