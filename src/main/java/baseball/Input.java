package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        isValidateUserNumber(userInput);

        return userInput;
    }

    public static boolean inputEndNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String value = Console.readLine();
        return isValidateEndNumber(value);
    }

    public static void isValidateUserNumber(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (!userInput.replaceAll("[1-9]", "").equals("")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (!isDuplicate(userInput)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static boolean isDuplicate(String userInput) {
        boolean[] overlapCheck = new boolean[3];

        for (int j = 0; j < 3; j++) {
            overlapCheck[j] = true;
            if (isSame(userInput, overlapCheck, j)) {
                return false;
            }
            overlapCheck[j] = false;
        }
        return true;
    }

}