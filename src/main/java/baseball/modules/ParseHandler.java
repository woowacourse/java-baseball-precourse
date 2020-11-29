package baseball.modules;

public class ParseHandler {
    public static int[] stringToIntArray(final String input, final int arrayLength){
        if(!ExceptionChecker.isParsableToInteger(input)){
            throw new IllegalArgumentException();
        }

        if(!ExceptionChecker.isLengthFit(input, arrayLength)){
            throw new IllegalArgumentException();
        }

        if(ExceptionChecker.isContainsZero(input)){
            throw new IllegalArgumentException();
        }

        int[] intArray = new int[arrayLength];
        for(int i = 0; i < input.length(); i++){
            intArray[i] = Character.getNumericValue(input.charAt(i));
        }

        if(!ExceptionChecker.isArrayElementsAreUnique(intArray)){
            throw new IllegalArgumentException();
        }

        return intArray;
    }

    public static int stringToOneOrTwo(final String input){
        if(!ExceptionChecker.isOneOrTwo(input)){
            throw new IllegalArgumentException();
        }
        
        return Integer.parseInt(input);
    }
}
