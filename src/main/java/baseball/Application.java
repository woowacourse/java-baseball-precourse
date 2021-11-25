package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String targetNumber = NumberGenerator.generate();
        System.out.println(targetNumber);
        String inputNumber = "";

        while (!inputNumber.equals(targetNumber)) {
            inputNumber = getConsoleInput();

            BaseBallResult result = calculateResult(targetNumber, inputNumber);
            System.out.println(result);
        }
    }

    private static BaseBallResult calculateResult(String target, String input) {
        BaseBallResult result = new BaseBallResult();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target.charAt(i)) {
                result.strikeCount++;
            } else if (target.contains(String.valueOf(input.charAt(i)))) {
                result.ballCount++;
            }
        }
        return result;
    }

    private static String getConsoleInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return input;
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
