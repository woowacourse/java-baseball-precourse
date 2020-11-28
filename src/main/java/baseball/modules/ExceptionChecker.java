package baseball.modules;

import java.util.HashSet;

public class ExceptionChecker {
    public static boolean isParsableToInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public static boolean isLengthFit(String input, int targetLength){
        return input.length() == targetLength;
    }

    public static boolean isContainsZero(String input){
        for(int i = 0; i < input.length(); i++){
            if(Character.getNumericValue(input.charAt(i)) == 0){
                return true;
            }
        }

        return false;
    }

    public static boolean isArrayElementsAreUnique(int[] input){
        HashSet<Integer> shown = new HashSet<Integer>();

        for(int i = 0; i < input.length; i++){
            if(shown.contains(input[i])){
                return false;
            }

            shown.add(input[i]);
        }

        return true;
    }    

    public static boolean isOneOrTwo(String input){
        int inputInteger = Integer.parseInt(input);
        return inputInteger == 1 || inputInteger == 2;
    }
}
