package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public static String inputBaseballNumbers() {
        System.out.print(REQUEST_INPUT_NUMBERS_MESSAGE);
        return Console.readLine();
    }
}