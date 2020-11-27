package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int userInput;
        int[] inputNumber;
        int[] randomNumber;
        boolean gameResult = false;
        while (!gameResult) {
            System.out.println("숫자를 입력해주세요 : ");
            userInput = scanner.nextInt();
            NumberUtils.validateInput(userInput);
            inputNumber = NumberUtils.createInputNumber(userInput);
            randomNumber = NumberUtils.createRandomNumber();
            gameResult = Baseball.playGame(inputNumber, randomNumber);
            if (gameResult) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameResult = restartGame();
            }
        }

    }

    private static boolean restartGame() {
        Scanner scanner = new Scanner(System.in);
        int userRestartInput;
        boolean restart = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userRestartInput = scanner.nextInt();
        if (userRestartInput <= 1) {
            restart = false;
        }
        return restart;
    }
}
