package baseball;

import java.util.Scanner;

public class User {
    private int[] userNumber = new int[Constant.NUMBER_LEN];

    public void enterNumber(Scanner scanner) {
        System.out.println(Constant.INPUT_MESSAGE);
        String number = scanner.next();

        if (Validation.isValidInput(number)) {
            setUserNumber(number);
        } else {
            throw new IllegalArgumentException(Constant.WRONG_INPUT);
        }
    }

    public int[] getUserNumber () {
        return this.userNumber;
    }

    private void setUserNumber(String number) {
        int eachNum;

        for (int i = 0; i < number.length(); i++) {
            eachNum = Character.getNumericValue(number.charAt(i));
            userNumber[i] = eachNum;
        }
    }
}
