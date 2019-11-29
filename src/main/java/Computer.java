import java.util.ArrayList;
import java.util.Random;

public class Computer {
    private ArrayList<Integer> answer = new ArrayList<>();

    Computer() {
    }

    void make_answer() {
        answer.clear();
        ArrayList<Integer> candidates = new ArrayList<>();
        Random random = new Random();
        candidates.add(1);
        candidates.add(2);
        candidates.add(3);
        candidates.add(4);
        candidates.add(5);
        candidates.add(6);
        candidates.add(7);
        candidates.add(8);
        candidates.add(9);
        for (int i = 0; i < 3; i++) {
            int random_index = random.nextInt(9-i);
            answer.add(candidates.get(random_index));
            candidates.remove(random_index);
        }
    }

}
