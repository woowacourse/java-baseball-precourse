package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import baseball.domain.RestartManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_OR_STOP_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

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

    public static RestartManager inputRestartOrStopRequest(Scanner scanner) {
        System.out.println(INPUT_RESTART_OR_STOP_REQUEST_MESSAGE);

        try {
            return new RestartManager(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputRestartOrStopRequest(scanner);
        }
    }
}
