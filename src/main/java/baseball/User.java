package baseball;

import java.util.Scanner;

public class User {
    private int[] userNumber = new int[Constant.NUMBER_LENGTH];

    public void enterNumber(Scanner scanner) {
        System.out.println(Constant.INPUT_MESSAGE);

        String number = scanner.next();

        if (Validation.isValidInput(number)) {
            setUserNumber(number);
        } else {
            throw new IllegalArgumentException(Constant.WRONG_INPUT);
        }
    }

    public int[] getUserNumber() {
        return this.userNumber;
    }

    private void setUserNumber(String number) {
        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            int eachNum = Character.getNumericValue(number.charAt(i));

            userNumber[i] = eachNum;
        }
    }
}
