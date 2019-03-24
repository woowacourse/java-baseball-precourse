import java.util.Scanner;
import java.util.Random;

public class BaseballGame {
    static boolean isWin() {
        return true;
    }

    static int[] makeArray() {
        Random rand = new Random(System.currentTimeMillis());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = rand.nextInt(8) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        while(true) {
            int[] arr = makeArray();
            boolean win = false;
            while(!win) {

                win = isWin();
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int re = stdIn.nextInt();
            if (re == 2)
                break;
        }
    }
}
