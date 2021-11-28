package baseball.utils;

import static baseball.constants.NumberConstant.ANSWER_LIST_LENGTH;
import static baseball.constants.NumberConstant.RANGE_END_NUM;
import static baseball.constants.NumberConstant.RANGE_START_NUM;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberList {

    public static List<Integer> generate() {
        List<Integer> newList = new ArrayList<>();
        boolean[] visited = new boolean[RANGE_END_NUM + 1];

        while (newList.size() < ANSWER_LIST_LENGTH) {
            Integer newNum = Randoms.pickNumberInRange(RANGE_START_NUM, RANGE_END_NUM);

            if (visited[newNum]) continue;

            visited[newNum] = true;
            newList.add(newNum);
        }

        return newList;
    }
}
