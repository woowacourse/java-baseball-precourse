package baseball;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> answerNumbersList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        String input = Console.readLine();
        validateType(input);
        validateRange(input);
        validateNumber(input);
    }

    // 인풋에 문자가 포함되어 있는지 확인한다.
    private static void validateType(String inputString) {
        try {
            Integer.parseInt(inputString);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 인풋의 각 자리가 1부터 9까지인지 확인한다.
    private static void validateRange(String inputString) {
        if(inputString.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    // 인풋이 서로 다른 3개의 숫자인지 확인한다.
    private static void validateNumber(String inputString){
        if(inputString.length() != 3 || Arrays.stream(inputString.split("")).distinct().count() != 3){
            throw new IllegalArgumentException();
        }
    }
}
