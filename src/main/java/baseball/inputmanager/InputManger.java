package baseball.inputmanager;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputManger<T> {
    public T getInput() {
        String input = Console.readLine();
        validate(input);
        return toReturn(input);
    }

    private void validate(String input) {
        if (!(isRightLength(input) && isRightCharacterRange(input))) {
            throw new IllegalArgumentException();
        }
    }

    abstract boolean isRightLength(String input);

    abstract boolean isRightCharacterRange(String input);

    abstract T toReturn(String input);
}
