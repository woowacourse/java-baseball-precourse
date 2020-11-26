package baseball;

public class InputValidator {

    private static final int START_NUMBER=48;

    private static final int END_NUMBER=57;

    private static final int NUMBER_LENGTH=3;

    public String isValidString(String inputString){
        if(isAllDigit(inputString)&&isRightLength(inputString)){
            return inputString;
        }else{
            throw new IllegalArgumentException("입력 오류");
        }
    }

    private boolean isAllDigit(String number){
        return number.chars().allMatch(this::isDigit);
    }

    private boolean isRightLength(String number){
        if(number.length()!=NUMBER_LENGTH)return false;
        return true;
    }

    private boolean isDigit(int ch){
        return ch>=START_NUMBER&&ch<=END_NUMBER;
    }
}
