package baseball.domain;

import java.util.List;

public class Referee {

    public Result judge(final List<Integer> answer, final List<Integer> guess) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < guess.size(); j++) {
                if (answer.get(i).equals(guess.get(j))) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }
        return new Result(strikeCount, ballCount);
    }
}
