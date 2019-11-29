public class BaseballGame {
    public void playGame() {
        Computer com = new Computer();
        User player = new User();

        com.getRandom();
        com.showAnswer();
        player.inputNumber();
        com.checkAnswer(player.getInput());
    }

    public static void main(String[] args) {
        BaseballGame play = new BaseballGame();

        play.playGame();
    }
}