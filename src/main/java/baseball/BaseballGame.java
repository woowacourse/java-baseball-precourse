package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public static Computer computer = new Computer();
    public static Player player = new Player();

    public static void gameStart() {
        int continueGame = playGameUntilGetAnswer(); // 1이면 게임을 계속한다. 2면 그만한다.
        System.out.println("continueGame = " + continueGame);

    }

    private static int playGameUntilGetAnswer() {
        computer.makeThreeDigitNumber();
        while (true) {
            int guessNumber = player.guessNumber();
            Result resultOfGuess = computer.compareGuessNumberAndAnswer(guessNumber);
            System.out.println(resultOfGuess.makeResultSentence());
            if (resultOfGuess.isAnswer()) {
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueGame = Console.readLine();
        if (continueGame.equals("1")) {
            return 1;
        }
        if (continueGame.equals("2")) {
            return 2;
        }
        throw new IllegalArgumentException("1 또는 2 이외의 값을 입력하셨습니다.");
    }
}
