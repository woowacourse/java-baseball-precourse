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

    public int getIntValue() {
        String stringNumber = getNextLine();
        int number = stringInputValueToInt(stringNumber);
        return number;
    }

    public int stringInputValueToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 해주세요");
        }
    }

    private String getNextLine() {
        return scanner.nextLine();
    }
}
