package baseball.game;

public class Validation {

    public static void isValidInput(String input) {
        if (!isRightLength(input)) {
            throw new IllegalArgumentException("잘못된 길이의 숫자입니다.");
        }
        if (!isRightRange(input)) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
        if (!isDuplicate(input)) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }

    private static boolean isRightLength(String input) {
        return input.length() == 3;
    }

    private static boolean isRightRange(String input) {
        int num;

        for (int i = 0; i < input.length(); i++) {
            num = Character.getNumericValue(input.charAt(i));
            if (num < 1 || num > 9) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDuplicate(String input) {
        int num;
        boolean[] visited = new boolean[10];

        for(int i=0; i<input.length(); i++){
            num = Character.getNumericValue(input.charAt(i));

            if (!visited[num]){
                visited[num] = true;
                continue;
            }
            return false;
        }

        return true;
    }


}
