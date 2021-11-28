package baseball;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }

    public void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            validateNumber(input.charAt(i));
        }
    }

    public void validateNumber(char c) {
        if (!(Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertStringToNumberList(String input) {
        validateLength(input);
        validateNumbers(input);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            result.add(input.charAt(i) - '0');
        }
        return result;
    }
}
