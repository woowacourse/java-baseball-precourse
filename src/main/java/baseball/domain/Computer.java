package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Computer {

    private final String randomNumbers;

    public Computer() {
        randomNumbers = createRandomNumbers();
    }

    public String createRandomNumbers() {
        LinkedHashSet<Integer> randomNumberBucket = new LinkedHashSet<>();
        while (randomNumberBucket.size() < 3) {
            randomNumberBucket.add(Randoms.pickNumberInRange(1, 9));
        }
        StringBuffer result = new StringBuffer();
        randomNumberBucket.forEach(result::append);
        return result.toString();
    }

    public String getRandomNumbers() {
        return randomNumbers;
    }
}
