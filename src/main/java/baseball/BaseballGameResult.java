package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballGameResult {
    static final int BALL = 0;
    static final int STRIKE = 1;
    static final int FINISH_THRESHOLD = 3;

    static final String BALL_MESSAGE = "볼";
    static final String STRIKE_MESSAGE = "스트라이크";
    static final String NOTHING_MESSAGE = "낫싱";

    private BaseballNumbers computerBaseballNumbers;
    private BaseballNumbers userBaseballNumbers;

    private Map<Integer, Integer> compareResult = new HashMap<>();

    private BaseballGameResult(BaseballNumbers computerBaseballNumbers,
                               BaseballNumbers userBaseballNumbers) {
        this.computerBaseballNumbers = computerBaseballNumbers;
        this.userBaseballNumbers = userBaseballNumbers;
        this.compareResult.put(BALL, 0);
        this.compareResult.put(STRIKE, 0);
    }

    public static BaseballGameResult getBaseballGameResult
            (BaseballNumbers computerBaseballNumbers, BaseballNumbers userBaseballNumbers) {
        BaseballGameResult baseballGameResult =
                new BaseballGameResult(computerBaseballNumbers, userBaseballNumbers);
        baseballGameResult.calculateResult();

        return baseballGameResult;
    }

    private void calculateResult() {
        int[] result = compareBaseballNumbers();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == i) {
                compareResult.put(STRIKE, compareResult.get(STRIKE) + 1);
            } else if (result[i] != -1) {
                compareResult.put(BALL, compareResult.get(BALL) + 1);
            }
        }
    }

    private int[] compareBaseballNumbers() {
        return userBaseballNumbers
                .getBaseballNumbers()
                .stream()
                .mapToInt(baseballNumber ->
                        computerBaseballNumbers.getBaseballNumbers().indexOf(baseballNumber))
                .toArray();
    }

    public boolean isFinished() {
        return compareResult.get(STRIKE) != FINISH_THRESHOLD;
    }

    @Override
    public String toString() {
        List<String> results = new ArrayList<>();

        if (compareResult.get(BALL) != 0) {
            results.add(compareResult.get(BALL) + BALL_MESSAGE);
        }

        if (compareResult.get(STRIKE) != 0) {
            results.add(compareResult.get(STRIKE) + STRIKE_MESSAGE);
        }

        if (results.size() == 0) {
            results.add(NOTHING_MESSAGE);
        }

        return String.join(" ", results);
    }
}
