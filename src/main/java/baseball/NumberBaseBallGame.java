package baseball;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import utils.RandomUtils;

public class NumberBaseBallGame {

    private static List<Integer> answerNumber = new LinkedList<>();

    public static void setAnswerNumber() {
        Set<Integer> set = new HashSet<>();

        answerNumber.clear();
        while (answerNumber.size() < 3) {
            int num = RandomUtils.nextInt(1, 9);
            if (!set.contains(num)) {
                set.add(num);
                answerNumber.add(num);
            }
        }
    }

}
