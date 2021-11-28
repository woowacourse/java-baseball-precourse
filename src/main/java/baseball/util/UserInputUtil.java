package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class UserInputUtil {

    private UserInputUtil() {
    }

    public static boolean checkProgress() {
        String input = Console.readLine();

        int number = toInteger(input);

        if (number == 1) {
            return true;
        } else if (number == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static int[] getThreeDigitInput() {
        int[] userNumber = new int[3];

        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        String[] stringArray = input.split("");

        for(int i = 0; i < 3; i++) {
            userNumber[i] = toInteger(stringArray[i]);
        }

        return userNumber;
    }

    private static int toInteger(String input) {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
