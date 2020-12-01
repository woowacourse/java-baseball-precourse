package baseball;

public class Validation {
    public static boolean isValidInput(String number) {
        return isNumber(number) && isRightLength(number)
                && isNotDuplicate(number) && isRightRange(number);
    }

    private static boolean isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char eachNum = number.charAt(i);

            if (!Character.isDigit(eachNum)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isRightLength(String number) {
        return number.length() == Constant.NUMBER_LEN;
    }

    private static boolean isNotDuplicate(String number) {
        boolean[] alreadyUse = new boolean[Constant.MAX_VALUE + 1];

        for (int i = 0; i < number.length(); i++) {
            int eachNum = Character.getNumericValue(number.charAt(i));

            if (!alreadyUse[eachNum]) {
                alreadyUse[eachNum] = true;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isRightRange(String number) {
        for (int i = 0; i < number.length(); i++) {
            int eachNum = Character.getNumericValue(number.charAt(i));

            if (eachNum < Constant.MIN_VALUE || eachNum > Constant.MAX_VALUE) {
                return false;
            }
        }

        return true;
    }
}
