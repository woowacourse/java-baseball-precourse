package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // 새게임 진행 여부 변수
        boolean keepPlaying = true;

        while(keepPlaying) {
            // 야구 게임 진행
            Player.playGame(scanner);
            // 새게임 진행 여부 확인
            keepPlaying = Game.continueGame();
        }


    }
}
