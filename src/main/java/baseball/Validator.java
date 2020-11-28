package baseball;

public class Validator {

    protected boolean isValidInputNumbers(String playerInput) {
        isValidInputSize(playerInput);
        isNumberIntegers(playerInput);
        isDifferentNumbers(playerInput);
        return true;
    }

    protected boolean isValidMenu(String menuId) {
        int menu = Integer.parseInt(menuId);
        if (menu > 2 || menu < 0)
            throw new IllegalArgumentException("선택하신 메뉴는 유효하지 않습니다.");
        return true;
    }

    private boolean isValidInputSize(String playerInput) {
        if (playerInput.length() > 3)
            throw new IllegalArgumentException("입력한 숫자의 수가 3개 보다 많습니다.");
        if (playerInput.length() < 3)
            throw new IllegalArgumentException("입력한 숫자의 수가 3개 보다 적습니다.");
        return true;
    }

    private boolean isNumberIntegers(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        for (char input : inputArr) {
            if (input < '1' || input > '9')
                throw new IllegalArgumentException("입력한 값이 1 ~ 9사이의 문자가 아닙니다.");
        }
        return true;
    }

    private boolean isDifferentNumbers(String playerInput) {
        char[] inputArr = playerInput.toCharArray();
        if (inputArr[0] == inputArr[1] || inputArr[0] == inputArr[2] || inputArr[1] == inputArr[2]) {
            throw new IllegalArgumentException("입력한 값에 중복된 값이 있습니다");
        }
        return true;
    }
}
