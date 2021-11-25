package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public static Computer computer = new Computer();
    public static Player player = new Player();

    public static void gameStart() {
        boolean continueGame = true;
        while (continueGame) {
            continueGame = playGameUntilGetAnswer();
        }
//        while (playGameUntilGetAnswer()) { } -> 코드는 짧아지는데 가독성이 안좋다고 생각함. 위에 방식을 사용할거. 나중에 마음이 바뀔 수도 있으니 기록에 남겨두기 위해 주석을 달았다.
    }

    private static Boolean playGameUntilGetAnswer() {
        computer.makeThreeDigitNumber();
        while (true) {
            int guessNumber = player.guessNumber();
            Result resultOfGuess = computer.compareGuessNumberAndAnswer(guessNumber);
            System.out.println(resultOfGuess.makeResultSentence());
            if (resultOfGuess.isAnswer()) {
                break;
            }
        }
        return decideToContinueGame();
    }

    private static Boolean decideToContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continueGame = Console.readLine();
        if (continueGame.equals("1")) {
            return true;
        }
        if (continueGame.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2 이외의 값을 입력하셨습니다.");
    }
}
