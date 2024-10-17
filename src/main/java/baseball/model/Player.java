package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Player {
    public String getNumberInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        validateNumberInput(input);
        return input;
    }

    public String getRestartInput() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = Console.readLine();
        validateRestartInput(input);
        return input;
    }

    private void validateNumberInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }

        Set<Character> digits = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
            }
            if (!digits.add(c)) {
                throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야 합니다.");
            }
        }
    }

    private void validateRestartInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}