package baseball;

import java.util.Arrays;
import java.util.regex.Pattern;

public class UserInput {
    public static int[] userInput(String userInput,int validCountOfNumber){
        String pattern = "[1-9]*";
        if (Pattern.matches(pattern,userInput) && userInput.length() == validCountOfNumber){
            int [] retValidNumber = new int[validCountOfNumber];
            for(int i=0;i<validCountOfNumber;i++){
                retValidNumber[i] =  userInput.charAt(i) - '0';
            }
            return retValidNumber;
        }
        throw new IllegalArgumentException();
    }
}
