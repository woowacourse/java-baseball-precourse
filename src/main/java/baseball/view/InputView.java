package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBaseBallNumbers = Console.readLine();
        return Arrays.stream(inputBaseBallNumbers.split(""))
            .map(Integer::new)
            .collect(Collectors.toList());
    }
}
