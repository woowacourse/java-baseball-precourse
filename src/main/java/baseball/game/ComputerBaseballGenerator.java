package baseball.game;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBaseballGenerator implements BaseballGenerator {
    private static final int BALL_COUNT = 3;

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public Baseball generateBaseBall() {
        return new Baseball(Stream
            .generate(() -> Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
            .distinct()
            .limit(BALL_COUNT)
            .toArray(Integer[]::new));
    }
}
