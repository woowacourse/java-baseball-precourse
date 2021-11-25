package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    private static List<BaseBallNumber> randomNumbers;

    public Computer() {
        this.randomNumbers = extractRandomNumbers();
    }

    private List<BaseBallNumber> extractRandomNumbers() {
        List<BaseBallNumber> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() != COUNT) {
            BaseBallNumber randomNumber = new BaseBallNumber(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
            if (randomNumbers.contains(randomNumber)) {
                continue;
            }
            randomNumbers.add(randomNumber);

        }
        return randomNumbers;
    }

    public List<BaseBallNumber> randomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
