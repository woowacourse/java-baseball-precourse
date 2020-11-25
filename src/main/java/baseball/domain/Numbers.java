package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private static final char INVALID_NUMBER = '0';

    public static char[] isValidNumbers(String threeNumbers) {
        //List<Character> numbers = new ArrayList<>();
        char[] numberList = threeNumbers.toCharArray();
        for(Character number : numberList){
            if (number.equals(INVALID_NUMBER)) throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        return numberList;
    }
}
