import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballGame {

    List<Integer> answer;
    Random random;


    public BaseballGame() {
    }

    public void init() {
        answer = new ArrayList<>();
        random = new Random();
    }

    public void start() {
        setAnswer();
    }

    public void reset() {

    }

    public void close() {

    }

    private void setAnswer() {
        do {
            int i = random.nextInt(9) + 1;
            if (!answer.contains(i))
                answer.add(i);
        } while (answer.size() < 3);
    }

}
