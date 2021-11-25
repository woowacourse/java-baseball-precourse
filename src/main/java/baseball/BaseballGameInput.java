package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameInput {

    private static final String BASEBALL_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private final BaseballGameInputValidator inputValidator;

    public BaseballGameInput() {
        inputValidator = new BaseballGameInputValidator();
    }

    public List<Integer> inputNumber() {
        System.out.print(BASEBALL_INPUT_MESSAGE);

        String numbers = Console.readLine();

        inputValidator.validateNumber(numbers);

        return toList(numbers);
    }

    private List<Integer> toList(String numbers) {
        List<Integer> numberList = new ArrayList<>();

        for (char number : numbers.toCharArray()) {
            numberList.add(number - '0');
        }
        return numberList;
    }
}
