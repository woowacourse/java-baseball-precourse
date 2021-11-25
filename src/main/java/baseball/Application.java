package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        String targetNumber = NumberGenerator.generate();
        System.out.println(targetNumber);
        String inputNumber = getConsoleInput();
        validateInput(inputNumber);

        BaseBallResult result = calculateResult(targetNumber, inputNumber);

        System.out.println(result);
    }

    private static BaseBallResult calculateResult(String targetNumber, String inputNumber) {
        BaseBallResult result = new BaseBallResult();
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) == targetNumber.charAt(i)) {
                result.strikeCount++;
            } else if (targetNumber.contains(String.valueOf(inputNumber.charAt(i)))) {
                result.ballCount++;
            }
        }
        return result;
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
