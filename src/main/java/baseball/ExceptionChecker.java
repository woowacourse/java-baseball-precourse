package baseball;

public class ExceptionChecker {
    
    static boolean checkException(String userChoice) {
        try {
            if (userChoice.length() != 3) {
                throw new IllegalArgumentException();
            } else if (userChoice.charAt(0) == userChoice.charAt(1) || userChoice.charAt(1) == userChoice.charAt(2) || userChoice.charAt(0) == userChoice.charAt(2)) {
                throw new IllegalArgumentException();
            } else if(userChoice.charAt(0) == '0' || userChoice.charAt(1) == '0' || userChoice.charAt(2) == '0') {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1~9의 각기 다른 3가지의 숫자를 입력해야 합니다");
            return true;
        }
        
        return false;        
    }

    static boolean checkException(int gameCoin) {
        try {
            if (gameCoin !=1 && gameCoin != 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않은 입력입니다.");
            return true;
        }

        return false;
    }

}
