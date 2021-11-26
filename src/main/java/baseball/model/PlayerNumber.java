package baseball.model;

import baseball.constant.Constant;
import baseball.constant.SystemMessage;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    private String playerNumber;

    public String getUserNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        if (isStringLengthCorrect(playerNumber) && isDigitPlayerNumber(playerNumber) && isDifferentPlayerNumber(playerNumber)) {
            this.playerNumber = playerNumber;
        }
    }

    public static boolean isStringLengthCorrect(String word) throws IllegalArgumentException {
        if (word.length() != Constant.USER_NUMBER_LENGTH) {
            throw new IllegalArgumentException(SystemMessage.NUMBER_LENGTH_NOT_CORRECT);
        }
        return true;
    }

    public boolean isDigitPlayerNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitCharInString(word, i);
        }
        return true;
    }

    public static boolean isDifferentPlayerNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException(SystemMessage.HAS_SAME_NUMBER);
        }
        return true;
    }

    public static boolean isDigitCharInString(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException(SystemMessage.STRING_IS_NOT_NUMBER);
        }
        return true;
    }
}
