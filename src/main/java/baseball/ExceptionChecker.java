package baseball;

public class ExceptionChecker {
    
    static void checkException(String userChoice) {
        if (userChoice.length() != 3) {
            throw new IllegalArgumentException();
        } else if (userChoice.charAt(0) == userChoice.charAt(1) || userChoice.charAt(1) == userChoice.charAt(2) || userChoice.charAt(0) == userChoice.charAt(1)) {
            throw new IllegalArgumentException();
        } else if(userChoice.charAt(0) == '0' || userChoice.charAt(1) == '0' || userChoice.charAt(2) == '0') {
            throw new IllegalArgumentException();
        }
    }

    static void checkException(int gameCoin) {
        if (gameCoin !=1 && gameCoin != 2) {
            throw new IllegalArgumentException();
        }
    }

}
