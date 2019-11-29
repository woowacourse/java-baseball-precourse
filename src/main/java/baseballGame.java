import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class baseballGame {
    int numbers[];
    Scanner scan;

    public void baseballNumber() {
        numbers = new int[]{1, 2, 3};
        this.setNumbers();
    }

    public void game() {
        scan = new Scanner(System.in);
        boolean judge = true;
        for (int j = 0; j < 5; j++) {
            System.out.print("숫자를 입력해주세요 : ");
            String meg = scan.next();
            int [] inputInt =  this.stringToint(meg);

            System.out.println(Arrays.toString(inputInt));
        }
    }

    public int[] stringToint(String num) {
        int [] intArray = Arrays.stream(num.split("")).mapToInt(Integer::parseInt).toArray();
        return intArray;
    }

    public void setNumbers() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(9) + 1;
            if (!Arrays.stream(numbers).anyMatch(x -> x == num)) {
                numbers[i] = num;
            } else {
                i--;
            }
        }
        this.game();
    }
}