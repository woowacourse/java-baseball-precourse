package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseBallUtil {
    private static final int DIGIT_NUM=3;
    private static final int START_NUM=1;
    private static final int END_NUM=9;

    public static int[] generateThreeRandomDigits(){
        List<Integer> pickedNumbers=Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, DIGIT_NUM);
        int[] threeRandomDigits=new int[DIGIT_NUM];
        for(int i=0; i<DIGIT_NUM; i++)
        {
            threeRandomDigits[i]= pickedNumbers.get(i);
        }
        return threeRandomDigits;
    }
}
