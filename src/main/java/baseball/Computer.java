package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int LENGTH = 3;
    private static final int MAX = 9;
    private static final int MIN = 1;

    private ArrayList<Integer> computerNumber = new ArrayList<Integer>();

    public ArrayList<Integer> createComputerNumber() {
        int number;

        while (computerNumber.size() < LENGTH) {
            number = Randoms.pickNumberInRange(MIN, MAX);
            this.checkDuplicateNumberInList(number);
        }

        return computerNumber;
    }

    /* 중복되지 않는 숫자 추가하는 함수 */
    private void checkDuplicateNumberInList(int number) {
        if (computerNumber.contains(number)) {
            return;
        }
        
        computerNumber.add(number);
    }

}
