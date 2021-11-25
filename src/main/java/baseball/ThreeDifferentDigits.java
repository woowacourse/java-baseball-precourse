package baseball;

import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;

class ThreeDifferentDigits{
    private String[] ThreeDifferentDigits;

    String[] getDigits(){
        return ThreeDifferentDigits;
    }

    ThreeDifferentDigits(){
        init3DiffDigits();
    }

    private void init3DiffDigits(){
        ThreeDifferentDigits = new String[3];
        int i = 0;
        while (i < 3){
            i = changeNullOfIndex(i);
        }
    }

    private int changeNullOfIndex(int index){
        int rand = Randoms.pickNumberInRange(1,9);
        String strOfRand = Integer.toString(rand);

        if (Arrays.asList(ThreeDifferentDigits).contains(strOfRand)) {
            return index;
        }

        ThreeDifferentDigits[index] = strOfRand;
        index++;
        return index;
    }
}