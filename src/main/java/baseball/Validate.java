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
//    public static boolean validate(int number) {
//        int first = number / 100;
//        int second = (number % 100) / 10;
//        int third = number % 10;
//
//        if (first == 0 || second == 0 || third == 0) {
//            return false;
//        }
//        else if (number >= 1000 || number < 100) {
//            return false;
//        }
//        else if (first == second || first == third || second == third) {
//            return false;
//        }
//        return true;
//    }
}
