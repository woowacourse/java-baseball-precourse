package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumbers {
    private static final int NUMBERS_SIZE = 3;
    private static final int RANGE_MIN_NUMBER = 1;
    private static final int RANGE_MAX_NUMBER = 9;

    private List<Integer> baseballNumbers = new ArrayList<>();

    public BaseballNumbers() {
        this.baseballNumbers = new ArrayList<>();
        generateNumbers();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(baseballNumbers);
    }

    private void generateNumbers() {
        while (validateSize()) {
            addRandomNumber(Randoms.pickNumberInRange(RANGE_MIN_NUMBER, RANGE_MAX_NUMBER));
        }
    }

    private boolean validateSize() {
        if (baseballNumbers.size() == NUMBERS_SIZE) {
            return false;
        }
        return true;
    }

    private void addRandomNumber(int randomNumber) {
        if (validateDuplicate(randomNumber)) {
            baseballNumbers.add(randomNumber);
        }
    }

    private boolean validateDuplicate(int randomNumber) {
        if (baseballNumbers.contains(randomNumber)) {
            return false;
        }
        return true;
    }
}