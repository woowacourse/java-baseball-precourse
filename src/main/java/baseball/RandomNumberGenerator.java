package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    List<Integer> numberList = new ArrayList<>();
    public void makeRandom(){
        for (int i=0; i<3; i++){
            numberList.add(Randoms.pickNumberInRange(0, 9));
        }
    }

}
