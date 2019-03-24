import java.util.Scanner;

public class BaseballGame {
    static boolean isWin() {
        return true;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        while(true) {
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
