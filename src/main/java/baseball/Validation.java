package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void isRightDigit(String tmpUserNumbers){
        ArrayList<Integer> tmpInputSet = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++){
            tmpInputSet.add(tmpUserNumbers.charAt(i) - '0');
        }
        for(int i = 0; i < tmpInputSet.size(); i++){
            if(!(tmpInputSet.get(i) >= 1 || tmpInputSet.get(i) <= 9))
                throw new IllegalArgumentException("숫자 1~9 이외의 문자는 입력할 수 없습니다.");
        }
    }
    public static void isThreeDigit(String tmpUserNumbers){
        if(tmpUserNumbers.length() != 3) {
            throw new IllegalArgumentException("입력 숫자는 0을 제외한 양의 정수 3개여야 합니다.");
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
