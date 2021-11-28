package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현
        NumberValidator validator = new ThreeDigitValidator();
        Ball ball = new Ball(new ThreeDigitGenerator(), validator);
        User user = new User();

        ball.generateNumber();
        String inputString = Console.readLine();

        List<Integer> inputNumbers = parseInput(inputString);
        validateInput(validator, inputNumbers);
        user.setNumbers(inputNumbers);
        
    }

    public static void validateInput(NumberValidator validator, List<Integer> inputNumbers) {
        if(!validator.validateNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseInput(String string) {
        List<Integer> parsedInput = new ArrayList<>(3);
        int stringLen = string.length();
        for (int index = 0; index < stringLen; index++) {
            char charAtIndex = string.charAt(index);
            isDigit(charAtIndex);
            parsedInput.add(Character.getNumericValue(charAtIndex));
        }
        return parsedInput;
    }

    public static void isDigit(char character) {
        if(!Character.isDigit(character)) {
            throw new IllegalArgumentException();
        }
    }
}
