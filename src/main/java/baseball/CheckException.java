package baseball;

import java.util.Arrays;
import java.util.List;

public class CheckException {
    static boolean isLengthProper(String input){
        List availableLength = Arrays.asList(1,3);

        return availableLength.contains(input.length());
    }

    static boolean isInputDigit(String input){
        char inputArr[] = input.toCharArray();

        for (char character : inputArr){
            if (!Character.isDigit(character)){
                return false;
            }
        }

        return true;
    }
}
