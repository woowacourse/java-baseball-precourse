package baseball;

import java.util.Scanner;

public class NumberBaseBallGame {
    private final Scanner scanner;
    private static final int playAgain = 1;
    private static final int stopPlay = 2;

    public NumberBaseBallGame(Scanner scanner){
        this.scanner = scanner;
    }

    private void askRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int doesPlayerWantPlayAgain = scanner.nextInt();
        validatePlayerWantPlayAgain(doesPlayerWantPlayAgain);

        if (doesPlayerWantPlayAgain == playAgain){
            start();
        }
    }

    private void validatePlayerWantPlayAgain(int doesPlayerWantPlayAgain) {
        if (doesPlayerWantPlayAgain != 1 && doesPlayerWantPlayAgain != 2){
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
    }

    public void start(){
        boolean isContinueGame = true;
        Digits answer = RandomNumberGenerator.makeRandomNumber();

        do {
            System.out.print("숫자를 입력해주세요 : ");

            Digits userInput = new Digits(scanner.nextInt()); // 에러 날 수 있는 곳.
            Discriminator discriminator = new Discriminator();
            isContinueGame = discriminator.judge(answer, userInput);

        } while (isContinueGame);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        askRestart();
    }
}
