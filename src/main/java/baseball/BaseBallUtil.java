
package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseBallUtil {
    private static final int DIGIT_NUM=3;
    private static final int START_NUM=1;
    private static final int END_NUM=9;
    private static final int ONLY_ONE=1;
    private static final String CHOICE_ONE="1";
    private static final String CHOICE_TWO="2";

    public static int[] generateThreeRandomDigits(){
        List<Integer> pickedNumbers=Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, DIGIT_NUM);
        int[] threeRandomDigits=new int[DIGIT_NUM];
        for(int i=0; i<DIGIT_NUM; i++)
        {
            threeRandomDigits[i]= pickedNumbers.get(i);
        }
        return threeRandomDigits;
    }

    public static boolean isValidateGuess(String input){
        if(input.length()!=DIGIT_NUM) return false;
        if(!isNumberFormat(input)) return false;
        if(!isZeroInNumber(input)) return false;

        return true;
    }

    public static boolean isValidateChoice(String input){
        if(input.length()!=ONLY_ONE) return false;
        if(!isNumberFormat(input)) return false;
        if(!isChoiceInRange(input)) return false;

        return true;
    }

    private static boolean isChoiceInRange(String input){
        if(input.equals(CHOICE_ONE) || input.equals(CHOICE_TWO)) return true;
        return false;
    }

    private static boolean isZeroInNumber(String input){
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='0') return false;
        }
        return true;
    }

    private static boolean isNumberFormat(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
