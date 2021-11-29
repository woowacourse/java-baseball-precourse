package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.resource.rule.NumberDigit;
import baseball.resource.rule.NumberRange;
import baseball.resource.rule.PlayOption;
import camp.nextstep.edu.missionutils.Console;

import baseball.exception.InputNotIntegerMessageException;
import baseball.exception.InputNumbersDuplicatedMessageException;
import baseball.exception.NumberOutOfRangeMessageException;

import baseball.resource.message.OutputMessage;

public class InputView {

    private static final InputView instance = new InputView();
    private static final OutputView outputView = OutputView.getInstance();

    public static InputView getInstance() {
        return instance;
    }

    public boolean inputPlayOrStop() {
        outputView.printMessageWithLine(OutputMessage.REQUEST_PLAY_OR_STOP_MESSAGE);
        int number = inputNumber();
        PlayOption playOption = PlayOption.of(number);
        return playOption.isPlayable();
    }

    public List<Integer> inputPlayerNumbers() {
        outputView.printMessage(OutputMessage.REQUEST_NUMBERS_MESSAGE);
        List<Integer> numbers = inputNumbers();

        validateNumbersDigitMatch(numbers);
        validateNumbersInRange(numbers);
        validateNumbersIsNotDuplicated(numbers);

        return numbers;
    }


    private int inputNumber() {
        try {
            String userInputData = Console.readLine();
            return Integer.parseInt(userInputData);
        } catch (NumberFormatException ex) {
            throw new InputNotIntegerMessageException();
        }
    }

    private List<Integer> inputNumbers() {
        try {
            String userInputData = Console.readLine();
            List<Integer> numbers = new ArrayList<>();
            for (char item : userInputData.toCharArray()) {
                int number = Integer.parseInt(String.valueOf(item));
                numbers.add(number);
            }
            return numbers;
        } catch (NumberFormatException ex) {
            throw new InputNotIntegerMessageException();
        }
    }

    private boolean isNotInRange(int number) {
        return (number < NumberRange.START.getNumber() || NumberRange.END.getNumber() < number);
    }

    private void validateNumbersDigitMatch(List<Integer> numbers) {
        NumberDigit.COUNT.isMatch(numbers.size());
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isNotInRange(number)) {
                throw new NumberOutOfRangeMessageException();
            }
        }
    }

    private void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        boolean[] bits = new boolean[10];
        for (int number : numbers) {
            if (bits[number]) {
                throw new InputNumbersDuplicatedMessageException();
            }
            bits[number] = true;
        }
    }

}
