package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputRole {

    private void checkValid(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 1-9로 이뤄진 3자리 수를 입력해주세요.");
        }
    }

    public String getInputValue() {
        String input = Console.readLine();
        checkValid(input);
        return input;

    }

}
