package baseball.game;

public class Validation {

    public static void isValidInput(String input) {
        if (!isRightLength(input)){
            throw new IllegalArgumentException("잘못된 길이의 숫자입니다.");
        }
    }

    private static boolean isRightLength(String input) {
        return input.length() == 3;
    }

}
