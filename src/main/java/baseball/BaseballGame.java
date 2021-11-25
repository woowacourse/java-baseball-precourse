package baseball;

public class BaseballGame {

    public static void gameStart() {

        Computer computer = new Computer();
        Player player = new Player();

        computer.makeThreeDigitNumber();
        while (true) {

            int guessNumber = player.guessNumber(); //TODO 맞출때까지 반복해줘야함.
            Result resultOfGuess = computer.compareGuessNumberAndAnswer(guessNumber);
            System.out.println(resultOfGuess.makeResultSentence());
            if (resultOfGuess.isAnswer()) {
                break;
            }
        }
    }
}
