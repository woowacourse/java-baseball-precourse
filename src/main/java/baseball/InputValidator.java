package baseball;

public class InputValidator {

    private final String message = "1부터 9까지 서로 다른 수로 이루어진 3자리의 수여야 합니다.";

    public void Validate(String input) {
        if(input.length() != 3) throw new IllegalArgumentException(message);

        for (int i = 0; i < 3; i++) {
            if(!isNum(input.charAt(i))) throw new IllegalArgumentException(message);
        }
    }

    private boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

}
