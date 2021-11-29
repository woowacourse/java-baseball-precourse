package baseball.game;

import java.util.Arrays;

public enum Command {
    RESTART("1"),
    END("2");

    private final String button;

    Command(String command) {
        this.button = command;
    }

    public static Command create(String input) {
        return Arrays.stream(Command.values())
            .filter(command -> command.button.equals(input))
            .findAny()
            .get();
    }

}
