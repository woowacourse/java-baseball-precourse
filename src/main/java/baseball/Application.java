package baseball;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

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
