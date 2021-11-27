package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    private static final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    private static final char START_NUMBER = '1';
    private static final char END_NUMBER = '9';
    private static final int INPUT_SIZE = 3;
    private static final String RESTART_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String OVER = "2";

    public void displayPrompt() {
        System.out.print(INPUT_PROMPT);
    }

    public List<Integer> inputNumberFromUser() {
        displayPrompt();
        String inputNumber = Console.readLine();

        List<Integer> inputNumberList = inputToIntegerList(inputNumber);
        validateLen(inputNumberList);
        validateDuplication(inputNumberList);

        return inputNumberList;
    }

    private List<Integer> inputToIntegerList(String inputNumber) {
        List<Integer> inputNumberList = new ArrayList<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            char inputChar = inputNumber.charAt(i);
            validateRange(inputChar);
            inputNumberList.add(inputChar - '0');
        }

        return inputNumberList;
    }

    private void validateRange(char inputChar) {
        if (inputChar < START_NUMBER || inputChar > END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLen(List<Integer> inputNumberList) {
        if (inputNumberList.size() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> inputNumberList) {
        if (inputNumberList.stream().distinct().count() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void displayRestartPrompt() {
        System.out.println(RESTART_PROMPT);
    }

    public String inputRestartFromUser() {
        displayRestartPrompt();
        String restartInput = Console.readLine();
        validateRestartInput(restartInput);

        return restartInput;
    }

    private void validateRestartInput(String restartInput) {
        if (!restartInput.equals(RESTART) && !restartInput.equals(OVER)) {
            throw new IllegalArgumentException();
        }
    }
}
