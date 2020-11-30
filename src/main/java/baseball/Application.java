package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean keepPlaying = true;

        while(keepPlaying) {
            Player.playGame(scanner);

            System.out.print("계속하려면 1 아니면 2 :");
            int answer = scanner.nextInt();
            if (answer == 2){
                keepPlaying = false;
            }

        }


    }
}
