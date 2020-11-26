package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public static BaseballNumbers inputBaseballNumbers(Scanner scanner) {
        System.out.print(INPUT_BASEBALL_NUMBERS_MESSAGE);
        String inputedNumbers = scanner.nextLine();

        try {
            List<BaseballNumber> baseballNumbers = Arrays.stream(inputedNumbers.split(""))
                    .map(Integer::new)
                    .map(BaseballNumber::new)
                    .collect(Collectors.toList());

            return new BaseballNumbers(baseballNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBaseballNumbers(scanner);
        }
    }
}
