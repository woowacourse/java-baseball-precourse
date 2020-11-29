package utils.validator;

public class NumberValidator {

    public static boolean isDigit(String string){
        for (int i=0; i<string.length(); i++){
            char ch = string.charAt(i);

            if (!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }
}
