package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public List<Integer> createRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        int count = ZERO;
        while (count < LIMITED_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (computerNumbers.contains(randomNumber)) {
                continue;
            }
            computerNumbers.add(randomNumber);
            count++;
        }
        return computerNumbers;
    }
}
