package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> list = new ArrayList<>();

    public Balls(List<Integer> list) {
        convertNumbersToBalls(list);
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
