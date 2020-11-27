package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class InputHandler {
    private static final String PLAYER_INPUT_EXCEPTION_MESSAGE = "1부터 9까지 중 서로 다른 3자리의 숫자를 입력해주세요 :)";
    private static final String PLAYER_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int INPUT_SIZE = 3;

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = this.scanner.nextLine();
        validateNumbers(input);
        return parse(input);
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = this.scanner.nextLine();
        validateRestart(input);
        if (input.equals("1")) {
            return true;
        }
        return false;
    }

    private void validateNumbers(String input) {
        if (input.length() != INPUT_SIZE) {
            throwInputException(PLAYER_INPUT_EXCEPTION_MESSAGE);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < INPUT_SIZE; i++) {
            set.add(input.substring(i, i+1));
        }
        if (set.size() < INPUT_SIZE) {
            throwInputException(PLAYER_INPUT_EXCEPTION_MESSAGE);
        }

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throwInputException(PLAYER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateRestart(String input) {
        String[] inputCandidate = {"1", "2"};
        for (String s : inputCandidate) {
            if (s.equals(input)) {
                return;
            }
        }
        throwInputException(PLAYER_RESTART_MESSAGE);
    }

    private void throwInputException(String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }

    private List<Integer> parse(String input) {
        List<Integer> parsed = new ArrayList<>();
        for (int i = 0; i < INPUT_SIZE; i++) {
            parsed.add(Integer.parseInt(input.substring(i, i+1)));
        }
        return parsed;
    }
}
