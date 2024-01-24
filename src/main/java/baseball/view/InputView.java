package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static int readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return validateAndParse(input);
    }

    public static int readCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = Console.readLine();
        return validateAndParse(command);
    }

    private static int validateAndParse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
    }
}
