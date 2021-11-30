package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberService {

    //컴퓨터 숫자 저장
    public void createComputerNumber(BaseballNumber computerNumber) {
        computerNumber.setNumber(getRandomNumber());
        boolean isBaseballNumber = checkNumber(computerNumber);
        if (!isBaseballNumber) {
            createComputerNumber(computerNumber);
        }
    }

    //3자리 난수 생성
    private int[] getRandomNumber() {
        int[] tmpComputerNumber = new int[3];
        int START_INCLUSIVE = 1;
        int END_INCLUSIVE = 9;
        for (int i = 0; i < 3; i++) {
            int digit = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            tmpComputerNumber[i] = digit;
        }
        return tmpComputerNumber;
    }

    //숫자야구에 적합한 3자리 수 인지 확인
    private boolean checkNumber(BaseballNumber number) {
        return isBaseballNumber(number.getNumber());
    }

    private boolean isBaseballNumber(int[] num) {
        return isNotZero(num);
    }

    // 0이 없는지
    private boolean isNotZero(int[] num) {
        if (num[0] == 0
                || num[1] == 0
                || num[2] == 0) {
            return false;
        }
        return checkOverlappedNum(num);
    }

    //중복된 숫자는 없는지
    private boolean checkOverlappedNum(int[] num) {
        if (num[0] == num[1]
                || num[1] == num[2]
                || num[0] == num[2]) {
            return false;
        }
        return true;
    }

    /*
    정수임을 보장 받지 못하는
    사용자 입력에 대해서는
    추가적인 예외처리를 진행 후
    숫자야구에 적합한 3자리 수 인지 확인
    예외시 IllegalArgumentException 발생시키기
     */

    public void checkUserInput(String userInput, BaseballNumber userNumber) throws
            IllegalArgumentException {

        int[] tmpUserNumber = toBaseballNumber(userInput);
        userNumber.setNumber(tmpUserNumber);
        if (!checkNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
    }

    /*
    문자열로 입력 받은
    사용자 숫자를
    int[]로 변경
     */
    private int[] toBaseballNumber(String userInput) {
        if (!checkLength(userInput)) {
            throw new IllegalArgumentException();
        }
        int[] userNumber = new int[3];
        String[] stringStream = userInput.split("");
        for (int i = 0; i < 3; i++) {
            userNumber[i] = Integer.parseInt(stringStream[i]);
        }
        return userNumber;
    }

    //길이가 3인지
    private boolean checkLength(String userInput) {
        if (userInput.length() != 3) {
            return false;
        }
        return isNumber(userInput);
    }

    //숫자인지
    private boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
