import java.util.Scanner;

public class GameExecutor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game(); // 지금은 아무 상태도 가지고 있지 않기에 동일한 game을 사용

        while(true) {
            game.play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

            int num = sc.nextInt();

            if (num == 2) break;
        }
    }
}
