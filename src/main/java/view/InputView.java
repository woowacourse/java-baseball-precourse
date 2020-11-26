package view;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WRONG_INPUT_MESSAGE = "잘못 입력하셨습니다. 숫자를 다시 입력해주세요 : ";

    private InputView() {
    }

    public static String inputBaseballNumbers(Scanner scanner) {
        System.out.print(INPUT_BASEBALL_NUMBERS_MESSAGE);
        String input = scanner.nextLine();
        while (isWrongPattern(input)) {
            System.out.print(WRONG_INPUT_MESSAGE);
            input = scanner.nextLine();
        }
        return input;
    }

    private static boolean isWrongPattern(String input) {
        try {
            validatePattern(input);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private static void validatePattern(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        Set<Character> characters = getCharacterStream(input)
                .collect(Collectors.toSet());
        if (characters.size() != 3) {
            throw new IllegalArgumentException();
        }
        if (getCharacterStream(input).anyMatch(c -> c < '1' || c > '9')) {
            throw new IllegalArgumentException();
        }
    }

    private static Stream<Character> getCharacterStream(String input) {
        return input.chars()
                .mapToObj(character -> (char) character);
    }
}
