package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public Computer() {

    }

    public char[] pickNumber() {
        char[] number = new char[3];
        boolean trying = false;
            while(!trying) {
                number = String.valueOf(Randoms.pickNumberInRange(100, 999)).toCharArray();
                if(number[0] == number[1] || number[1] == number[2] || number[2] == number[0]) {
                    trying = true;
                }
            }
        return number;
    }
}
