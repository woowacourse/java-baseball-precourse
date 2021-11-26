package baseball.model;

import baseball.constant.Constant;

import java.util.HashSet;
import java.util.Set;

public class UserNumber {
    private String userNumber;

    public UserNumber(String userNumber) {
        setUserNumber(userNumber);
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        if (isStringLengthThree(userNumber) && isDigitUserNumber(userNumber) && isSameAllUserNumber(userNumber)) {
            this.userNumber = userNumber;
        }
    }

    public static boolean isStringLengthThree(String word) throws IllegalArgumentException {
        if (word.length() != Constant.USER_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isDigitUserNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitCharInString(word, i);
        }
        return true;
    }

    public static boolean isSameAllUserNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isDigitCharInString(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
