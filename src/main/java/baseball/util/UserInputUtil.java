package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class UserInputUtil {

    private UserInputUtil() {
    }

    private static int toInteger(String input) {
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
