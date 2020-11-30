package baseball;

public class Validate {
    public static boolean isValidate(String number) {
        try {
            if (isInteger(number) && !hasZero(number) &&!exceedNumberSize(number) && !hasDuplicateNumber(number)) {
                return true;
            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    private static boolean isInteger(String guess) {
        try {
            Integer.parseInt(guess);
            return true;
        } catch (NumberFormatException exception){
            throw new IllegalArgumentException("입력 오류: 숫자가 아닙니다.");
        }
    }
    private static boolean hasZero(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) < '1' || guess.charAt(i) > '9') {
                throw new IllegalArgumentException("입력 오류: 숫자에 0포함");
            }
        }
        return false;
    }
    private static boolean exceedNumberSize(String guess) {
        if (guess.length() != 3) {
            throw new IllegalArgumentException("입력 오류: 세자리 숫자가 아님");
        }
        return false;
    }
    private static boolean hasDuplicateNumber(String guess) {
        char first = guess.charAt(0);
        char second = guess.charAt(1);
        char third = guess.charAt(2);
        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException("입력 오류: 중복된 숫자 존재");
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
            System.out.println("3개의 숫자를 모두 맞히셨습니다.");
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
