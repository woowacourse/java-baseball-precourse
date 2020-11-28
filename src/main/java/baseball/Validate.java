package baseball;

public class Validate {
    public static boolean isValidate(String number) {
        if (number.length() != 3) {
            System.out.println("입력 오류: 3자리 숫자가 아닙니다.");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) < '1' || number.charAt(i) > '9') {
                return false;
            }
        }
        char first = number.charAt(0);
        char second = number.charAt(1);
        char third = number.charAt(2);
        if (first == second || first == third || second == third) {
            return false;
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
