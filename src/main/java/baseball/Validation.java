package baseball;

import static baseball.Constant.GAME_LENGTH;
import static baseball.Constant.MAX_LENGTH;

public class Validation {
    // 사용자 입력 번호 확인
    public static boolean validateInputNumber(String inputNumber){
        if (!isNumeric(inputNumber) ||
            !compareBaseballLength(inputNumber) ||
             isReduplication(inputNumber)){
            return false;
        }
        return true;
    }
    // 사용자 새게임 여부 번호 확인
    public static boolean validateContinueGameNumber(String continueGameNumber){
        if (!isNumeric(continueGameNumber) ||
            !compareGameLength(continueGameNumber)){
            return false;
        }
        return true;
    }

    // 문자가 아닌지 확인
    public static boolean isNumeric(String inputNumber){
        return inputNumber.chars().allMatch(Character::isDigit);
    }

    // 야구게임 숫자의 길이 확인
    public static boolean compareBaseballLength(String inputNumber){
        return inputNumber.length() == MAX_LENGTH;
    }

    // 새게임 여부 변수의 길이 확인
    public static boolean compareGameLength(String continueGameNumber){
        return continueGameNumber.length() == GAME_LENGTH;
    }

    // 입력숫자에 중복이 있는지 확인
    public static boolean isReduplication(String inputNumber){
        char temp_a = inputNumber.charAt(0);
        char temp_b = inputNumber.charAt(1);
        char temp_c = inputNumber.charAt(2);

        if ((temp_a ^ temp_b) == 0 ||
            (temp_a ^ temp_c) == 0 ||
            (temp_b ^ temp_c) == 0 ){
            return true;
        }
        return false;
    }
}
