package baseball.model.Player;

import baseball.constant.Constant;
import baseball.constant.SystemMessage;

import java.util.HashSet;
import java.util.Set;

public class PlayerNumber {
    private String playerNumber;

    public PlayerNumber(String playerNumber) {
        isStringLengthCorrect(playerNumber);
        isDigitPlayerNumber(playerNumber);
        isDifferentPlayerNumber(playerNumber);

        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public static void isStringLengthCorrect(String word) throws IllegalArgumentException {
        if (word.length() != Constant.USER_NUMBER_LENGTH) {
            throw new IllegalArgumentException(SystemMessage.NUMBER_LENGTH_NOT_CORRECT);
        }
    }

    public void isDigitPlayerNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitCharInString(word, i);
        }
    }

    public static void isDifferentPlayerNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        if (set.size() != word.length()) {
            throw new IllegalArgumentException(SystemMessage.HAS_SAME_NUMBER);
        }
    }

    public static void isDigitCharInString(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException(SystemMessage.STRING_IS_NOT_NUMBER);
        }
    }
}
