package utils;

/**
 * @author junyoung.choi
 */
public class CheckUtils {

    CheckUtils(){
    }

    public static boolean isLengthThree(String inputNumber){

        return inputNumber.length() == 3;
    }

    public static boolean isDigit(String inputNumber){
        for(int i=0;i<3;i++){
            if(!Character.isDigit(inputNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void isAppropriate(String inputNumber){
        if(!isDigit(inputNumber) || !isLengthThree(inputNumber)){
            throw new IllegalArgumentException();
        }
    }
}