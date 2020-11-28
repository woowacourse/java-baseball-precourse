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
        if(isNull(input)){
            throw new IllegalArgumentException();
        }

        return input.length() == targetLength;
    }

    public static boolean isContainsZero(String input){
        if(isNull(input)){
            throw new IllegalArgumentException();
        }
        
        for(int i = 0; i < input.length(); i++){
            if(Character.getNumericValue(input.charAt(i)) == 0){
                return true;
            }
        }

        return false;
    }

    public static boolean isArrayElementsAreUnique(int[] input){
        if(isNull(input)){
            throw new IllegalArgumentException();
        }
        
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
        if(isNull(input)){
            throw new IllegalArgumentException();
        }

        if(!isParsableToInteger(input)){
            throw new IllegalArgumentException();
        }

        int inputInteger = Integer.parseInt(input);
        return inputInteger == 1 || inputInteger == 2;
    }

    public static boolean isNull(Object input){
        return input == null;
    }
}
