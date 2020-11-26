package baseball;

import java.util.HashSet;
import java.util.Set;

public class Checker {

    public boolean isCorrect(int tartgetValue, int input) {
        return tartgetValue == input;
    }

    public void isValid(int input) {
        Set<Character> set = new HashSet<>();
        char[] chars = String.valueOf(input).toCharArray();

        for (char c : chars) {
            set.add(c);
        }

        if (chars.length != 3) {
            throw new IllegalArgumentException(Message.LENGTH_WARNING_MESSAGE);
        } else if (set.size() != 3) {
            throw new IllegalArgumentException(Message.DUPLICATE_WARNING_MESSAGE);
        }
    }
}
