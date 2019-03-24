import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseBall {

    public static List<Integer> answerInit() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        return arr.subList(0, 3);
    }

    public static void main(String[] args) {
        List<Integer> answer = answerInit();

    }
}
