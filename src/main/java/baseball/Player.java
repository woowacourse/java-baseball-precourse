package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Ball> balls;

    public void selectBalls(List<Integer> numbers) {
        balls = new ArrayList<>();
        int position = Constant.MIN_VALUE;
        for (int number : numbers) {
            balls.add(new Ball(position++, number));
        }
    }
}
