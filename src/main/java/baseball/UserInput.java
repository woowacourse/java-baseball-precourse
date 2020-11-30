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

    public static void errorPrint(){
        System.out.println("에러 발생! 다음과 같은 데이터는 사용할 수 없습니다.");
        System.out.println("1. 중복된 숫자");
        System.out.println("2. 정해진 범위를 넘어서는 숫자");
        System.out.println("3. 숫자가 아닌 문자 혹은 숫자 0");
    }
}
