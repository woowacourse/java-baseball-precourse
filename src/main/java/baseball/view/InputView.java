package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBERS_DELIMITER = "";
    private static final int INPUT_NUMBERS_SIZE = 3;
    private static final String INPUT_RESTART_COMMAND = "1";
    private static final String INPUT_END_COMMAND = "2";

    public List<Integer> getInputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputNumbers = Console.readLine();
        validateSize(inputNumbers.length());
        return toList(inputNumbers);
    }

    public boolean isRestart() {
        String command = inputCommand();
        validateCommand(command);

        if (command.equals(INPUT_RESTART_COMMAND)) {
            return true;
        }
        return false;
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

    private String inputCommand() {
        System.out.println(INPUT_RESTART_MESSAGE);
        return Console.readLine();
    }

    private void validateCommand(String command) {
        if (!command.equals(INPUT_RESTART_COMMAND) && !command.equals(INPUT_END_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }
}