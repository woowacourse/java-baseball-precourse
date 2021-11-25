package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 세 자리의 입력을 받는 클래스.
 * 같은 숫자가 있거나, 올바르지 않은 숫자의 경우 예외를 발생시킴.
 */
public class BallInputNumber {
    static final int NUMBER_LENGTH = 3;
    static final int RANGE_START = 1;
    static final int RANGE_END = 9;

    private List<Integer> clientNumber;

    public BallInputNumber() {
        clientNumber = inputNumberByClient();
        InputNumberValidator inputNumberValidator = new InputNumberValidator(clientNumber);
        if (!inputNumberValidator.inputNumberExceptionCheck()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getClientNumber() {
        return clientNumber;
    }

    public List<Integer> inputNumberByClient() {
        String inputNumber = Console.readLine();
        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            inputNumberList.add(inputNumber.charAt(i) - '0');
        }
        return inputNumberList;
    }


}
