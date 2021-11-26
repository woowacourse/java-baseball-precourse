package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class RandomUtil {

    static public List<Integer> generateRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();
        for (int i = INITIAL_VALUE; i < NUM_LENGTH; i++) {
            randomNumList.add(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return randomNumList;
    }
}
