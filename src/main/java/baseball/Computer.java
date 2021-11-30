package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Message.*;

public class Computer {

    private List<Integer> answer = new ArrayList<>();

    public Computer() {
        makeAnswer();
    }

    public void makeAnswer() {
        final Set<Integer> hashSet = new HashSet<>();
        while (hashSet.size() < LENGTH_OF_ANSWER) {
            final int number = Randoms.pickNumberInRange(MIN, MAX);
            hashSet.add(number);
        }
        this.answer = new ArrayList<>(hashSet);
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
