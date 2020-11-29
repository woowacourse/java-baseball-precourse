package baseball;

public class InputException {
    public static final int INPUT_MAX_RANGE = 987;
    public static final int INPUT_MIN_RANGE = 123;
    public static final int PROPER_INPUT_LENGTH = 3;
    /**
     * 메서드 checkUserInput()는 플레이어가 입력한 인풋이 1에서 9까지 중복되지 않는 3자리 수인지 검증합니다.
     * @param userInput 플레이어가 콘솔에 입력한 인풋입니다.
     * @return userInput이 유효한 3자리 숫자라고 판단해 이를 정수로 변환해 반환한다.
     * @exception userInput 길이가 3이 아니거나, 정수로 변환 될 수 없는 경우, 3자리 수가 아닌 경우,
     * 3자리수 중에 중복된 숫자가 있거나 0이 포함되어 있는 경우 IllegalArgumentException 발생시킵니다.
     */
    public static int checkUserInput(String userInput) {
        /* 세자리수인지 확인한다 */
        checkStringLength(userInput);
        /* 정수로 변환 될 수 있는지 확인한다 */
        int userInputNumber = inputStringToInteger(userInput);
        /* 3자리 수인지 확인한다 */
        checkIntegerRange(userInputNumber);
        /* 중복되는 숫자가 있는지 확인한다 */
        checkIntegerDuplicate(userInputNumber);
        /* 중간에 0이 섞여 있는지 확인한다 */
        checkIntegerHasZero(userInputNumber);
        return userInputNumber;
    }

    public static void checkStringLength(String userInput) {
        if (userInput.length() != PROPER_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputStringToInteger(String userInput) {
        /* 정수로 변환 될 수 있는지 확인한다 */
        int userInputNumber;
        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }

    public static void checkIntegerRange(int userInputNumber) {
        /* 3자리 수인지 확인한다 */
        if(userInputNumber > INPUT_MAX_RANGE || userInputNumber < INPUT_MIN_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIntegerDuplicate(int userInputNumber) {
        int firstUserInputNumber = userInputNumber/100;
        int secondUserInputNumber = (userInputNumber/10)%10;
        int thirdUserInputNumber = userInputNumber%10;
        if((firstUserInputNumber == secondUserInputNumber) || (firstUserInputNumber == thirdUserInputNumber)
                || (secondUserInputNumber == thirdUserInputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIntegerHasZero(int userInputNumber) {
        int firstUserInputNumber = userInputNumber/100;
        int secondUserInputNumber = (userInputNumber/10)%10;
        int thirdUserInputNumber = userInputNumber%10;
        if(secondUserInputNumber == 0 || thirdUserInputNumber == 0) {
            /* firstUserInputNumber가 0인 경우는 위에서 감지되어 확인할 필요 없다 */
            throw new IllegalArgumentException();
        }
    }

}
