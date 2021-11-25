package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_NUMBERS_DELIMITER = "";
    private static final int INPUT_NUMBERS_SIZE = 3;

    public List<Integer> getInputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputNumbers = Console.readLine();
        validateSize(inputNumbers.length());
        return toList(inputNumbers);
    }

    private void validateSize(int size) {
        if (size != INPUT_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> toList(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(INPUT_NUMBERS_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}