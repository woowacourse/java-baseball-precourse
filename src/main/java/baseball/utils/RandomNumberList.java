package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.ANSWER_LIST_LENGTH;
import static baseball.Constants.RANGE_END_NUM;
import static baseball.Constants.RANGE_START_NUM;

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
