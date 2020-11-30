package baseball;

import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class Answer {
    private int min = 1;
    private int max = 1;

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> makeAnswer() {
        int randomNumber = RandomUtils.nextInt(min, max);
        if (!ans.contains(randomNumber)) {
            ans.add(randomNumber);
        }
        if (ans.size() == 3) {
            return ans;
        }
        return makeAnswer();
    }
}
