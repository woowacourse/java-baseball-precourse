package baseball;

public class Validate {

    protected boolean isValidInputSize(String playerInput) {
        if (playerInput.length() != 3)
            throw new IllegalArgumentException("입력한 숫자의 수가 3개가 아닙니다.");
        return true;
    }

    protected boolean isNumberInteger(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        for (char input : inputArr) {
            if (input < '1' || input > '9')
                throw new IllegalArgumentException("입력한 숫자가 1 ~ 9사이의 문자가 아닙니다.");
        }
        return true;
    }
}
