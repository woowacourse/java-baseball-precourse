package baseball.game;

public class Validation {

    public static void isValidInput(String input) {
        if (!isRightLength(input)) {
            throw new IllegalArgumentException(Constant.VALID_NUM_RANGE_ERROR);
        }
        if (!isRightRange(input, Constant.MIN_VALUE, Constant.MAX_VALUE)) {
            throw new IllegalArgumentException(Constant.NOT_NUM_ERROR);
        }
        if (!isDuplicate(input)) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NUM_ERROR);
        }
    }

    private static boolean isRightLength(String input) {
        return input.length() == Constant.NUMBER_LENGTH;
    }

    private static boolean isRightRange(String input, int min, int max) {
        int num;

        for (int i = 0; i < input.length(); i++) {
            num = Character.getNumericValue(input.charAt(i));
            if (num < min || num > max) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDuplicate(String input) {
        int num;
        boolean[] visited = new boolean[Constant.MAX_VALUE+1];

        for (int i = 0; i < input.length(); i++) {
            num = Character.getNumericValue(input.charAt(i));

            if (!visited[num]) {
                visited[num] = true;
                continue;
            }
            return false;
        }

        return true;
    }

    public static void isValidRestartInput(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.NOT_NUM_ERROR);
        }

        if (!isRightRange(input, Constant.GAME_RESTART, Constant.GAME_END)) {
            throw new IllegalArgumentException(Constant.NOT_NUM_ERROR);
        }
    }
}
