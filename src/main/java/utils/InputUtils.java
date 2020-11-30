package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 이 클래스는 사용자 입력값에 대한 유틸 클래스입니다.
 * 다음과 같은 책임을 가지는 클래스입니다.
 * 1. 사용자 입력에 대한 예외처리
 * 2. 사용자 입력 데이터 타입 변환
 */
public class InputUtils {

    private InputUtils() {}

    /** 문자열 입력값이 숫자인지 확인하는 함수 */
    public static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /** 문자열 입력값이 숫자 야구 게임의 길이(3)인지 확인하는 함수 */
    public static boolean isInputLengthEqualsToBaseballLength(String input) {
        return input.length() == BaseballDigitsGenerator.BASEBALL_LEN;
    }

    /** 문자열 입력값이 1부터 9사이의 값인지 확인하는 함수 */
    public static boolean isDigitInBaseballRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';

            if (digit <= BaseballDigitsGenerator.BASEBALL_NUM_MIN-1 || digit > BaseballDigitsGenerator.BASEBALL_NUM_MAX) {
                return false;
            }
        }
        return true;
    }

    /** 문자열 입력값이 메뉴 선택하는 범위안의 숫자인지 확인하는 함수 */
    public static boolean isDigitInMenuRange(String input) {
        int inputDigit = Integer.parseInt(input);

        if (inputDigit != 1 && inputDigit != 2) {
            return false;
        }

        return true;
    }

    /** 문자열 입력값을 숫자 리스트로 변환해주는 함수 */
    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> answer = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            answer.add(digit);
        }

        return answer;
    }
}
