package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    Ball balls;

    public String makeBalls() {
        balls = new Ball();
        String answer = "";
        List<String> list = balls.ball;
        while (list.size() != 3) {
            int a = Randoms.pickNumberInRange(1, 9);
            if(!balls.contains(a))
            list.add(String.valueOf(a));
        }
        return answer;
    }

}

