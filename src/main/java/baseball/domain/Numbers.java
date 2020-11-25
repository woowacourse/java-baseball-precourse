package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private static final int INVALID_NUMBER = 0;

    public List<Integer> isValidNumbers(String threeNumbers) {
        List<Integer> intNumberList = new ArrayList<>();
        char[] charNumberArray = threeNumbers.toCharArray();
        for(Character charNumber : charNumberArray){
            intNumberList.add(Character.getNumericValue(charNumber));
        }
        for(Integer number : intNumberList){
            if (number.equals(INVALID_NUMBER)) throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        return intNumberList;
    }
}
