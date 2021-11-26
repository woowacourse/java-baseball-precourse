package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        List<Integer> answerNumbersList = pickUniqueNumbersInRange(1, 9, 3);
    }
}
