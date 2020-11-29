package baseball;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean isRestart = true;
        boolean isPlaying;

        System.out.println("========");
        while(isRestart) {
            Opponent opponent = new Opponent();
            String opponentNumber = opponent.generateNumber();
            isPlaying = true;
            while(isPlaying) {
                System.out.printf("숫자를 입력해주세요 : ");
                String playerNumber = scanner.next();
                Player player = new Player();
                player.validate3Digits(playerNumber);
                Service service = new Service();

                service.counter(opponentNumber, playerNumber);
                service.printHint(service.ballCount, service.strikeCount);
                isPlaying = !service.isWin(service.ballCount, service.strikeCount);
            }

            if(!isPlaying) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String playerInput = scanner.next();
                Player.validateDigit(playerInput);
                isRestart = Service.finishBaseball(playerInput);
            }
        }

    } // end of Main
} // end of Application
