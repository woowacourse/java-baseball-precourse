package baseball.inputmanager;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputManger<T> {

    public T getInput() {
        String input = Console.readLine();
        validateInput(input);
        return toReturn(input);
    }

    private void validateInput(String input) {
        if (!(meetNumberOfDigitsLimit(input) && meetRangeOfCharacterLimit(input))) {
            throw new IllegalArgumentException();
        }
    }

    abstract boolean meetNumberOfDigitsLimit(String input);
    abstract boolean meetRangeOfCharacterLimit(String input);
    abstract T toReturn(String input);
}
