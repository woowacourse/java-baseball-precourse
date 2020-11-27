package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private static final String PLAYER_INPUT_EXCEPTION_MESSAGE = "1부터 9까지 중 서로 다른 3자리의 숫자를 입력해주세요 :)";
    private static final int INPUT_SIZE = 3;

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> get() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = this.scanner.nextLine();
        validate(input);
        return parse(input);
    }

    private void validate(String input) {
        if (input.length() != 3) {
            throwInputException();
        }

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throwInputException();
        }
    }

    private void throwInputException() {
        throw new IllegalArgumentException(PLAYER_INPUT_EXCEPTION_MESSAGE);
    }

    private List<Integer> parse(String input) {
        List<Integer> parsed = new ArrayList<>();
        for (int i = 0; i < INPUT_SIZE; i++) {
            parsed.add(Integer.parseInt(input.substring(i, i+1)));
        }
        return parsed;
    }
}
