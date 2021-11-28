package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.CurrentState;

public abstract class PlayerInput {
    private Console console;

    public int getPlayerInput(){
        printInputMessage();
        String userInput = console.readLine();
        isValidInput(userInput);
        return decodeUserInput(userInput);
    }

    private int decodeUserInput(String userInput) {
        return Integer.parseInt(userInput);
    }

    abstract boolean isSatisfiedBy(CurrentState status);
    abstract void printInputMessage();
    abstract void isValidInput(String userInput);

}
