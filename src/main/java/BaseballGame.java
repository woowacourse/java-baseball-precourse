import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
    }

    int[] makeComNum() {
        int[] comNum = new int[3];
        int[] checkOverlap = new int[10];

        for (int i = 0; i < 3; i++) {
            comNum[i] = (int) (Math.random() * 9) + 1;

            if (checkOverlap[comNum[i]] == 0) {
                checkOverlap[comNum[i]]++;
            } else {
                i--;
                continue;
            }
        }
        return comNum;
    }
}
