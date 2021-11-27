package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void isRightDigit(String tmpUserNumbers){
        for(int i = 0; i < tmpUserNumbers.length(); i++){
            if(!(tmpUserNumbers.charAt(i) >= '1' && tmpUserNumbers.charAt(i) <= '9'))
                throw new IllegalArgumentException(Message.INPUT_ERROR);
        }
    }

    public static void isThreeDigit(String tmpUserNumbers){
        if(tmpUserNumbers.length() != 3) {
            throw new IllegalArgumentException(Message.INPUT_ERROR);
        }
    }

    public static void isContainSameDigit(String tmpUserNumbers){
        Set<Integer> tmpInputSet = new HashSet<Integer>();

        for (int i = 0; i < 3; i++) {
            tmpInputSet.add(tmpUserNumbers.charAt(i) - '0');
        }
        if(tmpInputSet.size() != 3){
            throw new IllegalArgumentException(Message.INPUT_ERROR);
        }
    }

    public static void isRightChoose(Integer UserChoose){
        if(!(UserChoose == 1 || UserChoose == 2)){
            throw new IllegalArgumentException(Message.INPUT_ERROR);
        }
    }
}
