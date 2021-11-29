package baseball;


import java.util.HashMap;
import java.util.Map;

public class CheckException {
    static void is3DigitValid(String input) throws IllegalArgumentException {
        if (!(isLength3(input) && isInputDigit(input) && !isContainZero(input))){
            throw (new IllegalArgumentException("1-9 사이의 3자리 숫자를 입력해야 합니다."));
        }
    }

    static boolean isLength3(String input){
            return (input.length() == 3);
        }

    static boolean isInputDigit(String input){
        char[] inputArr = input.toCharArray();

        for (char character : inputArr) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    static boolean isContainZero(String input){
        return (input.contains("0"));
    }


    static void isRightCommand(String input) throws IllegalArgumentException {
        Map<String, String> commandList = new HashMap<>();
        commandList.put("1", "Start New Game");
        commandList.put("2", "End Game");

        if (commandList.containsKey(input)){
            return;
        }

        throw new IllegalArgumentException("명령어는 1 혹은 2 여야만 합니다.");
    }
}
