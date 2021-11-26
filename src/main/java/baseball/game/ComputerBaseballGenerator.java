package baseball.game;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBaseballGenerator implements BaseBallGenerator {

    private static final int BALL_COUNT = 3;

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public BaseBall generateBaseBall() {
        return new BaseBall(Stream
            .generate(() -> Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
            .distinct()
            .limit(BALL_COUNT)
            .toArray(Integer[]::new));
    }

}
