package baseball.model;

import baseball.view.InputView;

import java.util.HashSet;
import java.util.Set;
import static baseball.constant.ConstantNumber.*;

public class UserNumber {
    private String userNumber;

    public String getUserNumber() {
        return userNumber;
    }

    public UserNumber(String userNumber) {
        if (isStringLengthThree(userNumber) && isUserNumberDigit(userNumber) && isSameAllNumber(userNumber)) {
            this.userNumber = userNumber;
        }
    }

    public boolean isStringLengthThree(String word) throws IllegalArgumentException {
        if (word.length() != USER_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isUserNumberDigit(String word) {
        for (int i = 0; i < word.length(); i++) {
            isStringCharAtDigit(word, i);
        }
        return true;
    }

    public boolean isSameAllNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        if (set.size() != word.length()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isStringCharAtDigit(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException();
        }
        return true;
    }


}
