package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.exception.BaseballException;
import baseball.resource.GameMessage;
import baseball.resource.GameRule;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPlayOrStop() {
        OutputView.printMessageWithLine(GameMessage.REQUEST_PLAY_OR_STOP_MESSAGE);
        int number = inputNumber();

        checkNumberIsPlayOrStop(number);

        return number;
    }

    public static List<Integer> inputPlayerNumbers() {
        OutputView.printMessage(GameMessage.REQUEST_NUMBERS_MESSAGE);
        List<Integer> numbers = inputNumbers();

        checkNumbersDigit(numbers);
        checkNumbersRange(numbers);
        checkNumbersDuplication(numbers);

        return numbers;
    }


    private static int inputNumber() {
        try {
            String userInputData = Console.readLine();
            return Integer.parseInt(userInputData);
        } catch (NumberFormatException ex) {
            throw new BaseballException(GameMessage.NOT_NUMBER_MESSAGE);
        }
    }

    private static List<Integer> inputNumbers() {
        try {
            String userInputData = Console.readLine();
            List<Integer> numbers = new ArrayList<>();
            int number;
            for (char item : userInputData.toCharArray()) {
                number = Integer.parseInt(String.valueOf(item));
                numbers.add(number);
            }
            return numbers;
        } catch (NumberFormatException ex) {
            throw new BaseballException(GameMessage.NOT_NUMBER_MESSAGE);
        }
    }

    private static void checkNumberIsPlayOrStop(int number) {
        if (number != GameRule.NUMBER_GAME_PLAY && number != GameRule.NUMBER_GAME_STOP) {
            throw new BaseballException(GameMessage.NUMBER_NOT_IN_RANGE_MESSAGE);
        }
    }

    private static void checkNumbersDigit(List<Integer> numbers) {
        if (numbers.size() != GameRule.NUMBERS_DIGITS) {
            throw new BaseballException(GameMessage.NUMBERS_NOT_MATCH_DIGITS_MESSAGE);
        }
    }

    private static void checkNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isNotInRange(number)) {
                throw new BaseballException(GameMessage.NUMBER_NOT_IN_RANGE_MESSAGE);
            }
        }
    }

    private static void checkNumbersDuplication(List<Integer> numbers) {
        boolean[] bits = new boolean[10];
        for (int number : numbers) {
            if (bits[number]) {
                throw new BaseballException(GameMessage.NUMBERS_DUPLICATED_MESSAGE);
            }
            bits[number] = true;
        }
    }

    private static boolean isNotInRange(int number) {
        return (number < GameRule.NUMBERS_START_INCLUSION || GameRule.NUMBERS_END_INCLUSION < number);
    }
}
