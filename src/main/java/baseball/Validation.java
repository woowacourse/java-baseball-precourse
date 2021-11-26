package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void isRightDigit(String tmpUserNumbers){
        for(int i = 0; i < tmpUserNumbers.length(); i++){
            if(!(tmpUserNumbers.charAt(i) >= '1' && tmpUserNumbers.charAt(i) <= '9'))
                throw new IllegalArgumentException("숫자 1~9 이외의 문자는 입력할 수 없습니다.");
        }
    }

    public static void isThreeDigit(String tmpUserNumbers){
        if(tmpUserNumbers.length() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3자리여야 합니다.");
        }
    }

    public static void isContainSameDigit(String tmpUserNumbers){
        Set<Integer> tmpInputSet = new HashSet<Integer>();

        for (int i = 0; i < 3; i++) {
            tmpInputSet.add(tmpUserNumbers.charAt(i) - '0');
        }
        if(tmpInputSet.size() != 3){
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
