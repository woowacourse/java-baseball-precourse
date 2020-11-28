package baseball;

import java.util.HashSet;
import java.util.Set;

public class GamePlayer {
    private static final char FIRST_BOUNDARY_VALUE = '1';
    private static final char LAST_BOUNDARY_VALUE = '9';
    private static final int INPUT_NUMBER_COUNT = 3;
    private static final String REINPUT = "다시 입력해주세요";

    public static String getInputNumbers(String inputNumbers)
                                            throws IllegalArgumentException{
        if(inputNumbers.length() != INPUT_NUMBER_COUNT){
            throw new IllegalArgumentException(REINPUT);
        }

        if(isNotAllNumbers(inputNumbers)){
            throw new IllegalArgumentException(REINPUT);
        }

        if(haveDuplicateNumbers(inputNumbers)){
            throw new IllegalArgumentException(REINPUT);
        }

        return inputNumbers;
    }

    private static boolean isNotAllNumbers(String inputNumbers){
        for(int i=0; i<inputNumbers.length(); i++){
            if(inputNumbers.charAt(i) < FIRST_BOUNDARY_VALUE
                    || inputNumbers.charAt(i) > LAST_BOUNDARY_VALUE){
               return true;
            }
        }
        return false;
    }

    private static boolean haveDuplicateNumbers(String inputNumbers){
        Set<Character> numbers = new HashSet<>();
        for(int i=0; i<inputNumbers.length(); i++){
            numbers.add(inputNumbers.charAt(i));
        }
        return numbers.size() != INPUT_NUMBER_COUNT;
    }

}
