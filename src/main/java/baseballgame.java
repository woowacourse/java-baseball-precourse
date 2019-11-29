import GameMake.Baseball;
import java.util.Scanner;

public class baseballgame {
    public static void main(String[] args) {
        int exit = 0;
        Baseball game = new Baseball();
        Scanner sc = new Scanner(System.in);

        while(true) {
            game.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            exit = sc.nextInt();
            if (exit == 2) {
                break;
            }
        }
    }
}
