package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;
import java.util.stream.Collectors;

public class InputRole {

    private static final String INPUT_INSTRUCTiON = "숫자를 입력해주세요 : ";

    private void checkValid(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 1부터 9까지 서로 다른 수로 이뤄진 3자리 수를 입력해주세요.");
        }

        Set<Character> charSet = input.chars()
                .mapToObj(e -> ((char) e)).collect(Collectors.toSet()); // change string to char set
        if (charSet.size() != 3) {
            throw new IllegalArgumentException("중복된 입력값이 있습니다. 1부터 9까지 서로 다른 수로 이뤄진 3자리 수를 입력해주세요.");
        }
    }

    public String getInputValue() {
        System.out.print(INPUT_INSTRUCTiON);
        String input = Console.readLine();
        checkValid(input);
        return input;

    }

}
