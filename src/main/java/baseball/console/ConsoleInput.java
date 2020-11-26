package baseball.console;

import java.util.Scanner;

public final class ConsoleInput {

    private final Scanner scanner;

    private ConsoleInput(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static ConsoleInput of(final Scanner scanner) {
        return new ConsoleInput(scanner);
    }

    public String readPitchings() {
        return scanner.nextLine();
    }

    public int readNextGameStatus() {
        return Integer.parseInt(scanner.nextLine());
    }
}
