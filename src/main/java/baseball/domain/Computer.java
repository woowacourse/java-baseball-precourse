package baseball.domain;

import java.util.Arrays;
import java.util.List;

/**
 * 랜덤 숫자들을 만들고, 결과를 연산하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class Computer {
    public static final int INDEX_OF_BALLS = 0;
    public static final int INDEX_OF_STRIKES = 1;

    private final List<Integer> madeRandomNumbers;

    public Computer() {
        final RandomNumbers randomNumbers = new RandomNumbers();
        this.madeRandomNumbers = randomNumbers.makeRandomNumbers();
    }

    public List<Integer> calculateResult(List<Integer> inputNumbers) {
        int countsOfStrike = 0;
        int countsOfBall = 0;

        for (int i = 0; i < inputNumbers.size(); i++) {
            Integer numberInInputNumbers = inputNumbers.get(i);
            if (numberInInputNumbers.equals(this.madeRandomNumbers.get(i))) {
                countsOfStrike++;
            } else if (this.madeRandomNumbers.stream().anyMatch(j -> j.equals(numberInInputNumbers))) {
                countsOfBall++;
            }
        }
        return Arrays.asList(countsOfBall, countsOfStrike);
    }
}
