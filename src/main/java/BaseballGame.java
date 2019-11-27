import java.util.Random;
import java.util.Arrays;

public class BaseballGame {
    int numbers[];

    public void BaseballNumber() {
        numbers = new int[] {1, 2, 3};
        this.SetNumbers();
    }

    public void SetNumbers() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9) + 1;
            if (!Arrays.stream(numbers).anyMatch(x -> x == num)) {
                numbers[i] = num;
            } else {
                i--;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
