package baseball.validator;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerNumberFormatValidator {
    private static final int NUMBER_OF_NUMBERS = 3;

    public static boolean validate(String number){
        try {
            Set<Integer> numberSet = new HashSet<>(Arrays.stream(number.split(""))
                    .map(Integer::new)
                    .collect(Collectors.toSet()));
            if (number.length() != numberSet.size() || numberSet.size() != NUMBER_OF_NUMBERS) {
                return false;
            }
        }catch (NumberFormatException ne){
            return false;
        }
        return true;
    }
}
