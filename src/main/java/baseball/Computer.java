package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Computer {
    private LinkedHashSet<Integer> randomNumberSet = new LinkedHashSet<>();

    public void decideRandomNumber() {
        createNumber();
    }

    private void createNumber() {
        while(randomNumberSet.size()<3){
            randomNumberSet.add(Randoms.pickNumberInRange(1,9));
        }
    }




}
