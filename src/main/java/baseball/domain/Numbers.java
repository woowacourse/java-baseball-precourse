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
            if (number.equals(INVALID_NUMBER)) throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        if(threeNumbers.length()!=3) throw new IllegalArgumentException("숫자는 3개를 입력해야 합니다.");
        return intNumberList;
    }
}
