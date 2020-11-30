package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameNumberFormatValidator {
    private static final int[] ALLOWED_NUMBERS = new int[]{1, 2};

    public static boolean validate(String input){
        try {
            int number = Integer.parseInt(input);
            if(Arrays.binarySearch(ALLOWED_NUMBERS, number) < 0){
                return false;
            }
        }catch (NumberFormatException ne){
            return false;
        }
        return true;
    }
}
