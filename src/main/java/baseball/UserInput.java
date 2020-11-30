package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class UserInput {
    private static boolean duplicateCheck(int[] arr, int validCounteOfNumber){
        Set<Integer> duplicateCheckHash = new HashSet<>();
        for(int number:arr){
            duplicateCheckHash.add(number);
        }
        return duplicateCheckHash.size() == validCounteOfNumber;
    }

    public static int[] userInput(String userInput,int validCountOfNumber){
        int [] retValidNumber = new int[validCountOfNumber];
        String pattern = "[1-9]*";
        if (Pattern.matches(pattern,userInput) && userInput.length() == validCountOfNumber){
            for(int i=0;i<validCountOfNumber;i++){
                retValidNumber[i] =  userInput.charAt(i) - '0';
            }
        }
        if (duplicateCheck(retValidNumber,validCountOfNumber)){
            return retValidNumber;
        }
        throw new IllegalArgumentException();
    }
}
