import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Computer {
    static int[] computerAnswer = new int[3];

    public Computer() {
        List<Integer> candidate = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Random random = new Random();
        for (int i = 0; i < computerAnswer.length; i++) { // 정답확인
            int index = random.nextInt(candidate.size());
            computerAnswer[i] = candidate.get(index);
            candidate.remove(index);
        }
    }
}
