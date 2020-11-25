package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Number.*;

public class Ball {

    public List<Integer> computerBallGenerator() {
        List<Integer> balls = new ArrayList<>();
        int num;
        while(balls.size() < NUMBER_COUNT) {
            num = RandomUtils.nextInt(NUMBER_RANGE_ONE, NUMBER_RANGE_NINE);
            if(!balls.contains(num)) {
                balls.add(num);
            }
        }
        return balls;
    }

}
