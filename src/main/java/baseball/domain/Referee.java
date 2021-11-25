package baseball.domain;

import java.util.List;

public class Referee {

    public Result judge(final List<Integer> answer, final List<Integer> guess) {
        int strikeCount = countStrike(answer, guess);
        int ballCount = countBall(answer, guess);
        return new Result(strikeCount, ballCount);
    }

    private int countBall(List<Integer> answer, List<Integer> guess) {
        int ballCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (isAnySameValueWithDifferentIndex(answer.get(i), i, guess)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int countStrike(List<Integer> answer, List<Integer> guess) {
        int strikeCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isAnySameValueWithDifferentIndex(Integer value, int index, List<Integer> target) {
        for (int i = 0; i < target.size(); i++) {
            if (i == index) {
                continue;
            }
            if (value.equals(target.get(i))) {
                return true;
            }
        }
        return false;
    }

}
