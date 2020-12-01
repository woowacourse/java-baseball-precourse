package baseball;

import java.util.Scanner;

public class User {
    private int[] userNumber = new int[Constant.NUMBER_LEN];

    public void enterNumber(Scanner scanner) {
        System.out.println(Constant.INPUT_MESSAGE);
        String number = scanner.next();

        if (isValidInput(number)) {
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

    private boolean isValidInput(String number) {
        return isNumber(number) && isRightLength(number)
                && isNotDuplicate(number) && isRightRange(number);
    }

    private boolean isNumber(String number) {
        char eachNum;

        for (int i = 0; i < number.length(); i++) {
            eachNum = number.charAt(i);

            if (!Character.isDigit(eachNum)) {
                return false;
            }
        }

        return true;
    }

    private boolean isRightLength(String number) {
        return number.length() == Constant.NUMBER_LEN;
    }

    private boolean isNotDuplicate(String number) {
        int eachNum;
        boolean[] alreadyUse = new boolean[Constant.MAX_VALUE + 1];

        for (int i = 0; i < number.length(); i++) {
            eachNum = Character.getNumericValue(number.charAt(i));

            if (!alreadyUse[eachNum]) {
                alreadyUse[eachNum] = true;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isRightRange(String number) {
        int eachNum;

        for (int i = 0; i < number.length(); i++) {
            eachNum = Character.getNumericValue(number.charAt(i));

            if (eachNum < Constant.MIN_VALUE || eachNum > Constant.MAX_VALUE) {
                return false;
            }
        }

        return true;
    }
}
