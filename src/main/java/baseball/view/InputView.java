package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static String INPUT_NUMBERS_DELIMITER = "";

    private InputView() {
    }

    public static List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputBaseBallNumbers = Console.readLine();
        return Arrays.stream(inputBaseBallNumbers.split(INPUT_NUMBERS_DELIMITER))
            .map(Integer::new)
            .collect(Collectors.toList());
    }
}
