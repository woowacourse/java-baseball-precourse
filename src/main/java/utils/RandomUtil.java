package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class RandomUtil {

    static public List<Integer> generateRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();
        boolean[] check = new boolean[DECIMAL_DIGIT];
        while (randomNumList.size() < NUM_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!check[randomNum]) {
                randomNumList.add(randomNum);
                check[randomNum] = true;
            }
        }
        return randomNumList;
    }
}
