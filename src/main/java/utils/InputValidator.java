package utils;
import java.util.*;

public class InputValidator {

    private InputValidator(){}

    public static boolean validGuessNumber(String inputNumber, int len) throws Exception{
        if(!isValidLength(inputNumber, len)){
            return false;
        }

        if(!isNumericString(inputNumber)){
            return false;
        }

        if(!isAllDifferent(inputNumber)){
            return false;
        }

        return true;
    }

    public static boolean validPlayAgainAnswer(String input) throws Exception{
        if(!isNumericString(input)){
            return false;
        }
        return true;
    }

    private static boolean isValidLength(String input, int len){
        if(input.length() == len){
            return true;
        }
        return false;
    }

    private static boolean isNumericString(String input){
        try{
            Integer.parseInt(input);
        }catch (IllegalArgumentException IAE){
            return false;
        }
        return true;
    }

    private static boolean isAllDifferent(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for(int i =0; i<chars.length-1; i++){
            if(chars[i] == chars[i+1]){
                return false;
            }
        }
        return true;
    }
}
