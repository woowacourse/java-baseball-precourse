package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";

    private static final int ZERO = 0;

    private List<Integer> computerNumber;

    Computer(RandomNumberMaker randomNumberMaker) {
        this.computerNumber = randomNumberMaker.makeRandomNumber();
    }

    public boolean isStrike(List<Integer> userNumber, int nowIndex) {
        if (computerNumber.get(nowIndex) == userNumber.get(nowIndex)) {
            return true;
        }
        return false;
    }

    public boolean isBall(List<Integer> userNumber, int nowIndex) {
        if (computerNumber.contains(userNumber.get(nowIndex))) {
            return true;
        }
        return false;
    }

    public Map<String, Integer> compareWithUserNumber(List<Integer> userNumber) {
        Map<String, Integer> strikeAndBall = new HashMap<>();
        int strikeCount = ZERO;
        int ballCount = ZERO;
        for (int i = 0; i < userNumber.size(); i++) {
            if (isStrike(userNumber, i)) {
                strikeCount++;
                continue;
            }
            if (isBall(userNumber, i)) {
                ballCount++;
            }
        }
        strikeAndBall.put(STRIKE, strikeCount);
        strikeAndBall.put(BALL, ballCount);
        return strikeAndBall;
    }
}