package baseball;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExceptionChecker {
    private static final String ONLY_NUM = "^[1-9]+$";

    static boolean checkChoiceException(String userChoice) {
        try {
            if (userChoice.length() != 3) {
                throw new IllegalArgumentException();
            } else if (userChoice.charAt(0) == userChoice.charAt(1) || userChoice.charAt(1) == userChoice.charAt(2) || userChoice.charAt(0) == userChoice.charAt(2)) {
                throw new IllegalArgumentException();
            } else if (!numberCheck(userChoice)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1~9의 각기 다른 3가지의 숫자를 입력해야 합니다");
            return true;
        }
        return false;        
    }

    static boolean numberCheck(String str) {
        Pattern p = Pattern.compile(ONLY_NUM);
        Matcher m = p.matcher(str);

        return m.find();
    }

    static boolean checkCoinException(String gameCoin) {
        try {
            if (!gameCoin.equals("1") && !gameCoin.equals("2")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 입력입니다.");
            return true;
        }
        return false;
    }
}
