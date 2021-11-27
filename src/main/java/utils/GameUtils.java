package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static List<Integer> generateAnswerNumberList() {
        List<Integer> newList = new ArrayList<>();
        boolean[] visited = new boolean[10];

        while (newList.size() < 3) {
            Integer newNum = Randoms.pickNumberInRange(1, 9);

            if (visited[newNum]) continue;

            visited[newNum] = true;
            newList.add(newNum);
        }

        return newList;
    }
}
