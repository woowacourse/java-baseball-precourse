package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    Ball balls;

    public String makeBalls() {
        balls = new Ball();
        String answer = "";
        List<Integer> list = balls.ball;
        while (list.size() != 3) {
            int a = Randoms.pickNumberInRange(1, 9);
            if(!balls.contains(a))
            list.add(a);
        }
        for(int i=0;i<list.size();i++){
            answer+=String.valueOf(list.get(i));
        }
        return answer;
    }

}

