package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int NUMBER_SIZE = 3;
    private static final int RANGE_MAX_NUMBER = 9;
    private static final int RANGE_MIN_NUMBER = 1;
    private String number;

    public void initNumber() {
        number="";
        while(number.length()<NUMBER_SIZE) {
            int pick = Randoms.pickNumberInRange(RANGE_MIN_NUMBER,RANGE_MAX_NUMBER);
            String pickString = Integer.toString(pick);
            if(!number.contains(pickString)) {
                number = number.concat(Integer.toString(pick));
            }
        }
    }

    public String getNumber() {
        return number;
    }
}
