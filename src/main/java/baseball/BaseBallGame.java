package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallGame {

    private static final int NUMBER_LENGTH = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private final List<Integer> targetNumber;

    public BaseBallGame() {
        targetNumber = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < NUMBER_LENGTH) {
            result.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return shuffle(new ArrayList<>(result));
    }

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }
}
