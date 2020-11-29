package baseball;

import utils.PlayBall;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        while(true) {

            PlayBall playBall = new PlayBall();
            playBall.play(scanner);

            if(checkReplay(playBall, scanner)) {
                break;
            }
            /* 게임을 새로 시작하기 위해 1 입력 후 enter 입력 시 IllegalArgumentException 오류가 throw 됨.
             * 따라서 이를 막기 위해 nextLine()으로 다음 줄을 무시.
             */
            //scanner.nextLine();
        }
    }

    public static boolean checkReplay(PlayBall playBall, Scanner scanner) {
        while(true) {
            try {
                boolean check_replay = playBall.isReplay(scanner);
                return check_replay;
            } catch(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        }
    }
}

