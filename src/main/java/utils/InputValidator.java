package utils;

public class InputValidator {

    public static void inGameNumber(String inputString, int requiredLength) {
        if (inputString.length() != requiredLength) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < requiredLength; i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        if (inputString.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    public static void gameStartOrStop(String inputString, String RESTART_GAME, String FINISH_GAME) {
        if (!inputString.equals(RESTART_GAME) && !inputString.equals(FINISH_GAME)) {
            throw new IllegalArgumentException();
        }
    }
}
