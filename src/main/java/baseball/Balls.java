package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final int BALLS_SIZE = 3;

    private List<Ball> list = new ArrayList<>();

    public Balls(List<Integer> list) {
        validateDuplication(list);
        convertNumbersToBalls(list);
    }

    private void validateDuplication(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void convertNumbersToBalls(List<Integer> numbers) {
        for (int number : numbers) {
            list.add(new Ball(number));
        }
    }

    public List<Ball> getList() {
        return list;
    }
}
