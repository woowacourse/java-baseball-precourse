package baseball;

import java.util.Scanner;

public class User {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_LEN = 3;

    int[] userNumber = new int[NUMBER_LEN];

    public void enterNumber(Scanner scanner) {
        System.out.println(INPUT_MESSAGE);
        String number = scanner.nextLine();

        if (isValidInput(number)) {
            setUserNumber(number);
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void setUserNumber(String number) {
        int eachNum;

        for (int i = 0; i < number.length(); i++) {
            eachNum = Character.getNumericValue(number.charAt(i));
            userNumber[i] = eachNum;
        }
    }

    private boolean isValidInput(String number) {
        return true;
    }
}
