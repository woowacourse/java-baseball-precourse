package baseball.utils;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static List<Integer> RandomNumberList() {
        boolean[] visited = new boolean[10];
        List<Integer> RandomList = new ArrayList<>();

        while (RandomList.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (visited[number]) continue;

            RandomList.add(number);
            visited[number] = true;
        }

        return RandomList;
    }
}
