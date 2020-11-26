package utils;

import java.util.Scanner;

public class InputUtils {

    private final Scanner scanner;

    private InputUtils(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputUtils of(final Scanner scanner) {
        return new InputUtils(scanner);
    }
}
