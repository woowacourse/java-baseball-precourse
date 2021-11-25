package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String targetNumber = NumberGenerator.generate();
        String inputNumber = getConsoleInput();
        validateInput(inputNumber);
    }

    private static String getConsoleInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static void validateInput(String input) throws IllegalArgumentException {
        if (input.length() != 3 || !isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
