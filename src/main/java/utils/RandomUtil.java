package utils;

import baseball.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    static public List<Integer> generateRandomNum() {
        List<Integer> randomNumList = new ArrayList<>();
        for (int i = 0; i < Game.NUM_LENGTH; i++) {
            randomNumList.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumList;
    }
}
