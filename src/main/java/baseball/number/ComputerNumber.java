package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {

    int[] computerNumber;

    public void creatComputerNumber() {
        int[] tmpNumber = getRandomNumber();
        boolean isBaseballNumber = checkNumber(tmpNumber);
        if(isBaseballNumber) {
            computerNumber = tmpNumber;
        } else if (!isBaseballNumber){
            creatComputerNumber();
        }
    }

    public boolean checkNumber(int[] num) {
        return NumberService.isBaseballNumber(num);
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


}
