import java.util.Scanner;

// 19-03-26 2차 리팩토링
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay gamePlay = new GamePlay();

        boolean flag = true;
        while (true) {
            flag = gamePlay.init(flag);
            gamePlay.requestInputMessage();
            gamePlay.getUserInput(sc.next().split(""));
            gamePlay.countResult();
            gamePlay.getGameResult().print();
            // !!-- indent depth 3 이상
            if (gamePlay.getGameResult().isEnd()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int input = sc.nextInt();
                if (input == 2) {
                    break;
                } else {
                    flag = true;
                }
            }
            gamePlay.getGameResult().initGameResult();
        }
    }
}
