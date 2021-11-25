package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberService {

    public void createComputerNumber(BaseballNumber computerNumber) {
        int[] tmpNumber = getRandomNumber();
        boolean isBaseballNumber = checkNumber(tmpNumber);
        if(isBaseballNumber) {
            computerNumber.setNumber(tmpNumber);
        } else if (!isBaseballNumber){
            createComputerNumber(computerNumber);
        }
    }

    private boolean checkNumber(int[] num) {
        return isBaseballNumber(num);
    }

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

    private boolean isBaseballNumber(int[] num) {
        if(checkOverlappedNum(num)){
            return true;
        }
        return false;
    }

    private boolean checkOverlappedNum(int[] num) {
        if(num[0] == num[1]
                || num[1] == num[2]
                || num[0] == num[2]) {
            return false;
        }
        return true;
    }

//    private static boolean isNotZero(int[] num) {
//        if(num[0] == 0
//                || num[1] == 0
//                || num[0] == 0) {
//            return false;
//        }
//        return checkOverlappedNum(num);
//    }

//    private static boolean checkLength(int[] num) {
//        if(num.length != 3){
//            return false;
//        }
//        return checkOverlappedNum(num);
//    }
}
