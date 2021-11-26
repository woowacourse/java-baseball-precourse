package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameInput {

    private static final String BASEBALL_GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BASEBALL_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int RESTART_CODE = 1;

    private final BaseballGameInputValidator inputValidator;

    public BaseballGameInput() {
        inputValidator = new BaseballGameInputValidator();
    }

    public List<Integer> inputNumber() {
        System.out.print(BASEBALL_GAME_INPUT_MESSAGE);
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

    public boolean isContinue() {
        System.out.println(BASEBALL_GAME_RESTART_MESSAGE);
        int code = Integer.parseInt(Console.readLine());

        return code == RESTART_CODE;
    }
}
