package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static utils.Constant.BALLS_LENGTH;

public class Validator {

    public static boolean isInvalidBall(String candidate) {
        if(isIncorrectLength(candidate) || ( ! isNumber(candidate))
                || isNumberDuplicate(candidate) || isContainZero(candidate) ){
            return true;
        }
        return false;
    }
    public static boolean isNumberDuplicate(String candidate) {
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<BALLS_LENGTH; i++){
            list.add(candidate.charAt(i));
        }
        HashSet<Character> hashSet = new HashSet<Character>(list);
        if(hashSet.size() == BALLS_LENGTH){
            return false;
        }
        return true;
    }


    private static boolean isNumber(String candidate) {
        try {
            Integer.parseInt(candidate);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static boolean isContainZero(String candidate) {
        if(candidate.contains("0")){
            return true;
        }
        return false;
    }

    private static boolean isIncorrectLength(String candidate) {
        if(candidate.length() == BALLS_LENGTH){
            return false;
        }
        return true;
    }



}
