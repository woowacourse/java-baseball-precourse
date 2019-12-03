/**
 * class name : Check.class
 *
 * version : V0.1
 *
 * date : 2019.12.2
 *
 * copyright :
 *
 * description : 사용자 입력을 바탕으로 정답과 비교하여 strike, ball을 기능을 가진 클래스
 */

import java.util.ArrayList;

public class Check {
    public int checkStrike(ArrayList<Integer> input, ArrayList<Integer> result) {
        int strike = 0;

        for (int i = 0; i < result.size(); i++) {
            if (input.get(i) == result.get(i)) {
                strike++;
            }
        }

        return strike;
    }

    public int checkBall(ArrayList<Integer> input, ArrayList<Integer> result) {
        int index = 0 ;
        int ball = 0;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(index) == result.get((index + 1) % result.size())) {
                 ball++;
            }
            if (input.get(index) == result.get((index + 2) % result.size())) {
                ball++;
            }
            index++;

        }
        return ball;
    }
}
