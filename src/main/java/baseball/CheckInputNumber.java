package baseball;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 입력한 값이 조건에 맞는지 검사하는 클래스
 */
public class CheckInputNumber {

    private static final String INPUT_EXCEPTION_MESSAGE = "3자리의 서로 다른 숫자를 입력해주세요.";
    private static final String RESTART_INPUT_EXCEPTION_MESSAGE = "1(다시 시작) 또는 2(종료)를 입력해주세요.";
    private static final String[] oneOrTwo = {"1", "2"};


    public String inputNumber(String input) {
        if (!isValid(input)) {
            throwInputException(INPUT_EXCEPTION_MESSAGE);
        }
        return input;
    }

    public boolean isValid(String input) {

        if (!isUnique(input)) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (!isValidInteger(num)) {
                return false;
            }
        }
        return true;
    }

    public boolean oneOrTwo(String input) {
        if(Arrays.asList(oneOrTwo).contains(input)){
            return isOne(input);
        }
        throwInputException(RESTART_INPUT_EXCEPTION_MESSAGE);
        return false;
    }

    private boolean isOne(String input){
        return (input.equals("1"));
    }

    private boolean isUnique(String input) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.substring(i, i + 1));
        }
        return isLengthThree(set);
    }

    private boolean isLengthThree(Set<String> set) {
        return set.size() == 3;
    }

    private boolean isValidInteger(char inputChar) {
        return !(inputChar < 49 || inputChar > 57);
    }

    private void throwInputException(String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
