package baseball;

import java.util.Scanner;

public class Application {
    final static int LENGTH = 3;
    final static int GO = 1;
    //게임을 이어갈껀지만 결정하는 main
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Start s = new Start();
        int check = GO;

        //depth가 2 이하로 만들어야하는 것.
        while(check == GO) {
            try {
                GameCycle g = new GameCycle();
                g.gameStart();
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
            do {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            } while (!Start.restart(check = scanner.nextInt()));
        }
    }
}
