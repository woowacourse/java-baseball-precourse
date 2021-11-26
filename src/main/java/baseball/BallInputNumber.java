package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 세 자리의 입력을 받는 클래스.
 * 같은 숫자가 있거나, 올바르지 않은 숫자의 경우 예외를 발생시킴.
 */
public class BallInputNumber {
    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private List<Integer> clientNumber;

    public BallInputNumber() {
        clientNumber = new ArrayList<>();
    }

    public List<Integer> makeInputNumber() {
        System.out.print(INPUT_MESSAGE);
        String inputNumber = Console.readLine();
        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            inputNumberList.add(inputNumber.charAt(i) - '0');
        }
        return inputNumberList;
    }

    public List<Integer> inputNumberByClient() {
        List<Integer> inputNumberList = makeInputNumber();
        if (!InputNumberValidator.inputNumberExceptionCheck(inputNumberList)) {
            throw new IllegalArgumentException();
        }
        clientNumber = inputNumberList;
        return clientNumber;
    }
}
