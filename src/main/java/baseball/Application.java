package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean isRestart = true;
        boolean isPlaying;

        while (isRestart) {
            Opponent opponent = new Opponent();
            opponent.generateNumber();
            isPlaying = true;

            while (isPlaying) {
                System.out.printf("숫자를 입력해주세요 : ");
                String playerInput = scanner.next();
                String playerNumber = InputValidator.isValid3Digits(playerInput);

                Service service = new Service();
                service.counter(opponent.getOpponentNumber(), playerNumber);
                service.printHint();
                isPlaying = !service.isWin();
            }

            if (!isPlaying) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String playerInput = scanner.next();
                String playerAnswer = InputValidator.isValid1Digit(playerInput);
                isRestart = Service.isRestartBaseball(playerAnswer);
            }
        }
    }
}