package baseball.domain;

import java.util.Arrays;

public enum Command {
    RESTART("1"),
    EXIT("2");

    private final String symbol;

    Command(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static Command findCommandBySymbol(String input) {
        return Arrays.stream(Command.values())
            .filter(command -> command.symbol.equals(input))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("Invalid Command"));

    }
}
