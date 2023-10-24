package baseball;

import static constants.BaseballMessage.*;

import java.util.List;


public class BaseBallPlay {

    private int countStrike(List<Integer> answer, List<Integer> userinput) {
        int strike = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx).equals(userinput.get(idx))) {
                strike++;
            }
        }
        return strike;
    }

}