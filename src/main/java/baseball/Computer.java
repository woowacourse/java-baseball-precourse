package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String number;

    public void initNumber() {
        number="";
        while(number.length()<3) {
            int pick = Randoms.pickNumberInRange(1,9);
            String pickString = Integer.toString(pick);
            if(number.contains(pickString)) {
               continue;
            }
            number = number.concat(Integer.toString(pick));
        }
    }

    public String getNumber() {
        return number;
    }
}
