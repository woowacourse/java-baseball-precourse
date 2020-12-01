package baseball;

/**
 * 사용자가 입력한 숫자가 1~9사이의 서로 다른 3자리 숫자가 맞는지 검사하고 저장하는 클래스
 *
 * @version 1.0 2020-11-29
 */
public class User {
    private String number = "";

    private static final int START_CHAR_VAL = '1';
    private static final int END_CHAR_VAL = '9';
    private static final int SIZE = 3;

    /**
     * 사용자의 입력을 받아서 조건을 만족하면 숫자를 만드는 메서드
     *
     * @param input 사용자의 입력을 매개변수로 받습니다.
     * @throws IllegalArgumentException 조건을 만족하지 못하면 해당 예외를 던집니다.
     */
    public void makeNumber(String input) throws IllegalArgumentException {
        checkInputSize(input);
        checkNumber(input);
        checkDuplicate(input);
        this.number = input;
    }

    /**
     * 사용자가 입력한 값의 길이가 3인지 검사하는 메서드 3이 아니라면 IllegalArgumentException 발생시킴
     *
     * @param input 사용자의 입력값
     */
    private void checkInputSize(String input) {
        if (input.length() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자의 입력값의 각 자리가 1에서 9사이의 숫자인지 검사하는 메서드
     *
     * @param input 사용자의 입력값
     */
    private void checkNumber(String input) {
        for (int i = 0; i < SIZE; i++) {
            char aChar = input.charAt(i);
            isRightNumber(aChar);
        }
    }

    /**
     * 매개변수로 받은 char 변수가 1에서 9 사이의 변수인지 확인하는 메서드
     *
     * @param aChar 사용자의 입력값에서 가져온 하나의 문자
     */
    private void isRightNumber(char aChar) {
        if (aChar < START_CHAR_VAL || aChar > END_CHAR_VAL) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자의 입력값 3자리 중에 중복된 값이 있는지 확인하는 메서드
     *
     * @param input 사용자의 입력값
     */
    private void checkDuplicate(String input) {
        for (int i = 0; i < SIZE-1; i++) {
            char aChar = input.charAt(i);
            char otherChar = input.charAt(i + 1);
            isNumberEqual(aChar, otherChar);
        }
    }

    /**
     * 두 문자가 같은 지 확인하는 메서드 같다면 IllegalArgumentException 예외를 발생시킵니다.
     *
     * @param aChar 중복인지 확인하려는 문자 1
     * @param otherChar 중복인지 확인하려는 문자 2
     */
    private void isNumberEqual(char aChar, char otherChar) {
        if (aChar == otherChar) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumber() {
        return this.number;
    }
}
