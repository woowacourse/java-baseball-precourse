package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final int ZERO = 0;

    private List<Integer> randomNumbers;

    Computer() {
        this.randomNumbers = RandomNumberMaker.makeRandomNumbers();
    }

    public Map<String, Integer> compareWithUserNumber(List<Integer> userNumber) {
        Map<String, Integer> strikeAndBall = new HashMap<>();
        int strikeCount = ZERO;
        int ballCount = ZERO;

        for (int i = 0; i < userNumber.size(); i++) {
            if (randomNumbers.get(i) == userNumber.get(i)) {
                strikeCount++;
                continue;
            }

            if (randomNumbers.contains(userNumber.get(i))) {
                ballCount++;
            }
        }

        strikeAndBall.put(STRIKE, strikeCount);
        strikeAndBall.put(BALL, ballCount);
        return strikeAndBall;
    }
}