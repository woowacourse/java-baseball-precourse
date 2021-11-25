package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Ball> balls;

    public List<Ball> getBalls() {
        return balls;
    }

    public Computer() {
        balls = new ArrayList<>();
        int position = 1;
        for (int generateNumber : RandomNumberGenerate()) {
            Ball ball = new Ball(position++, generateNumber);
            balls.add(ball);
        }
    }

    public List<Integer> RandomNumberGenerate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Constant.MAX_SIZE) {
            int number = Randoms.pickNumberInRange(Constant.MIN_VALUE, Constant.MAX_VALUE);
            if (!randomNumbers.contains(number))
                randomNumbers.add(number);
        }
        return randomNumbers;
    }
}
