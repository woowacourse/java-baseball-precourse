package baseball;

public class Validate {

    public static final String ERR_MSG_NOT_INTEGER = "입력 오류: 숫자가 아닙니다.";
    public static final String ERR_MSG_HAS_ZERO = "입력 오류: 숫자에 0포함";
    public static final String ERR_MSG_NOT_3_DIGITS = "입력 오류: 세자리 숫자가 아님";
    public static final String ERR_MSG_DUPLICATE_NUMBER = "입력 오류: 중복된 숫자 존재";
    public static final String MSG_SUCCESS = "3개의 숫자를 모두 맞히셨습니다.";
    public static final int MODE_VALIDATE = 1;

    public static boolean isValidate(String number, Integer mode) {
        try {
            if (isInteger(number) && !hasZero(number) &&!exceedNumberSize(number) && !hasDuplicateNumber(number)) {
                return true;
            }
        } catch (IllegalArgumentException e){
            if (mode == MODE_VALIDATE) {
                System.out.println(e);
            }
            return false;
        }
        return true;
    }
    public static boolean isInteger(String guess) {
        try {
            Integer.parseInt(guess);
            return true;
        } catch (NumberFormatException exception){
            throw new IllegalArgumentException(ERR_MSG_NOT_INTEGER);
        }
    }
    public static boolean hasZero(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) < '1' || guess.charAt(i) > '9') {
                throw new IllegalArgumentException(ERR_MSG_HAS_ZERO);
            }
        }
        return false;
    }
    public static boolean exceedNumberSize(String guess) {
        if (guess.length() != 3) {
            throw new IllegalArgumentException(ERR_MSG_NOT_3_DIGITS);
        }
        return false;
    }
    public static boolean hasDuplicateNumber(String guess) {
        char first = guess.charAt(0);
        char second = guess.charAt(1);
        char third = guess.charAt(2);
        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException(ERR_MSG_DUPLICATE_NUMBER);
        }
        return true;
    }
    public static boolean isAnswer(String guess, String answer) {
        Integer strike = 0;
        Integer ball = 0;

        for (int i = 0; i < 3; i++) {
            int idx = answer.indexOf(guess.charAt(i));
            if (idx == i) {
                strike++;
            }
            else if (idx > -1) {
                ball++;
            }
        }
        if (strike == 3) {
            System.out.println(MSG_SUCCESS);
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼 ");
        } else if (ball == 0 ) {
            System.out.println(strike + "스트라이크 ");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
}
