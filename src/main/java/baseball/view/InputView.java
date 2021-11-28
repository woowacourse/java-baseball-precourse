package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.exception.BaseballException;
import baseball.resource.GameMessage;
import baseball.resource.GameRule;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();
    private static final OutputView outputView = OutputView.getInstance();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPlayOrStop() {
        outputView.printMessageWithLine(GameMessage.REQUEST_PLAY_OR_STOP_MESSAGE);
        int number = inputNumber();

        validateNumberIsPlayOrStop(number);

        return number;
    }

    public List<Integer> inputPlayerNumbers() {
        outputView.printMessage(GameMessage.REQUEST_NUMBERS_MESSAGE);
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
            throw new BaseballException(GameMessage.NOT_NUMBER_MESSAGE);
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
            throw new BaseballException(GameMessage.NOT_NUMBER_MESSAGE);
        }
    }

    private boolean isNotInRange(int number) {
        return (number < GameRule.NUMBERS_START_INCLUSION || GameRule.NUMBERS_END_INCLUSION < number);
    }

    private void validateNumberIsPlayOrStop(int number) {
        if (number != GameRule.NUMBER_GAME_PLAY && number != GameRule.NUMBER_GAME_STOP) {
            throw new BaseballException(GameMessage.NUMBER_NOT_IN_RANGE_MESSAGE);
        }
    }

    private void validateNumbersDigitMatch(List<Integer> numbers) {
        if (numbers.size() != GameRule.NUMBERS_DIGITS) {
            throw new BaseballException(GameMessage.NUMBERS_NOT_MATCH_DIGITS_MESSAGE);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isNotInRange(number)) {
                throw new BaseballException(GameMessage.NUMBER_NOT_IN_RANGE_MESSAGE);
            }
        }
    }

    private void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        boolean[] bits = new boolean[10];
        for (int number : numbers) {
            if (bits[number]) {
                throw new BaseballException(GameMessage.NUMBERS_DUPLICATED_MESSAGE);
            }
            bits[number] = true;
        }
    }

}
