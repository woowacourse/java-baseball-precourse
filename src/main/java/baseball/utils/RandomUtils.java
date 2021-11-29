package baseball.utils;

import baseball.game.Constant;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static List<Integer> RandomNumberList() {
        boolean[] visited = new boolean[Constant.MAX_VALUE+1];
        List<Integer> RandomList = new ArrayList<>();

        while (RandomList.size() < Constant.NUMBER_LENGTH) {
            int number = Randoms.pickNumberInRange(Constant.MIN_VALUE, Constant.MAX_VALUE);

            if (visited[number]) continue;

            RandomList.add(number);
            visited[number] = true;
        }

        return RandomList;
    }
}
