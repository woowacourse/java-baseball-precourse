package baseball;

public class InputValidator {

    public boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public boolean checkLength(String number,int length) {
        if(number.length() == length) {
            return true;
        }
        return false;
    }

    public boolean checkNumberScope(String number) {
        for(int i=0; i<number.length(); i++) {
            if('0' == number.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
