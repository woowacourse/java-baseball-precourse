package baseball;

import java.util.HashSet;

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

    public boolean checkDistinct(String number) {
        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0; i<number.length(); i++) {
            hashSet.add(number.charAt(i));
        }
        if(hashSet.size()!=3) {
            return false;
        }
        return true;
    }

    public boolean checkSelectScope(String number) {
        int numberInt = Integer.parseInt(number);
        if(numberInt != 1 && numberInt != 2) {
            return false;
        }
        return true;
    }
}
