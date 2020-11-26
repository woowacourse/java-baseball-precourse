package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {

    static final int MY_NUM_LENGTH = 3;

    public List<Integer> inputList(int inputNum) {
        List<Integer> myNum = new ArrayList<>();
        if((inputNum < 100) || (inputNum > 999)) {
            throw new IllegalArgumentException();
        }
        for(int i = 0 ; i < MY_NUM_LENGTH; i++) {
            String strNum = Integer.toString(inputNum);
            String str = Character.toString(strNum.charAt(i));
            myNum.add(Integer.parseInt(str));
        }
        int n1 = myNum.get(0);
        int n2 = myNum.get(1);
        int n3 = myNum.get(2);
        if((n1 == n2) || (n2 == n3) || (n3 == n1)) {
            throw new IllegalArgumentException();
        }
        return myNum;
    }

}
