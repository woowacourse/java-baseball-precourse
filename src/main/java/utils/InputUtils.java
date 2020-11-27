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
        return stringInputValueToInt(getNextLine());
    }

    private String getNextLine() {
        return checkLength(scanner.nextLine());
    }

    public int stringInputValueToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 해주세요");
        }
    }

    public String checkLength(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력 해주세요");
        }
        return text;
    }
}
