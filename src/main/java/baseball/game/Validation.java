package baseball.game;

public class Validation {

    public static void isValidInput(String input) {
        if (!isRightLength(input)) {
            throw new IllegalArgumentException("잘못된 길이의 숫자입니다.");
        }
        if (!isRightRange(input)) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
    }

    private static boolean isRightLength(String input) {
        return input.length() == 3;
    }

    private static boolean isRightRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (num<1 || num>9){
                return false;
            }
        }

        return true;
    }

}
