import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    int numbers[];
    Scanner scan;

    public void BaseballNumber() {
        numbers = new int[] {1, 2, 3};
        this.SetNumbers();
    }

    public void Game() {
        scan = new Scanner(System.in);
        boolean judge = true;
        for (int j=0; j < 5; j++) {
            System.out.print("숫자를 입력해주세요 : ");
            String meg = scan.next();
        }
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
        this.Game();
    }
}