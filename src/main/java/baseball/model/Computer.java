package baseball.model;

import java.util.List;
import java.util.ArrayList;

import static baseball.model.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public List<Integer> generateGameAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() != ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(STARTINCLUSIVE, ENDINCLUSIVE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}

