import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        List<Integer> numbers = createNumbers();
        
    }

    private static List<Integer> createNumbers() {
        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int temp = rand.nextInt(MAX_NUMBER) + 1;

            if (!isNumberUnique(temp, numbers)) {
                i--;

                continue;
            }

            numbers.add(temp);
        }

        return numbers;
    }

    private static boolean isNumberUnique(int temp, List<Integer> numbers) {
        boolean flag = true;

        for (Integer number : numbers) {
            if (temp == number) {
                flag = false;

                break;
            }
        }

        return flag;
    }
}
