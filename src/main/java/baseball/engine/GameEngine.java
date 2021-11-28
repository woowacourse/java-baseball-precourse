package baseball.engine;

import baseball.data.GameData;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private List<Integer> generateAnswer() {
        List<Integer> results = new ArrayList<Integer>();

        while(results.size() < GameData.NUM_OF_ANSWER) {
            Integer number = Integer.valueOf(Randoms.pickNumberInRange(0, 9));
            if(!results.contains(number)) {
                results.add(number);
            }
        }

        return results;
    }

}
