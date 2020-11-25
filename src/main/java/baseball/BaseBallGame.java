package baseball;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.domain.Number.*;

public class BaseBallGame {

    private int calculateStrike(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, NUMBER_COUNT)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

}
