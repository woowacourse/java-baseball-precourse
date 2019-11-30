public class BaseballGame {
    private NumbersGroup numbersGroupForComparison;
    private User user;
    private boolean gameIsRunning;

    public BaseballGame() {
        numbersGroupForComparison = NumbersGroup.makeNumbersGroupRandomly();
        user = new User();
        gameIsRunning = true;
    }

    public void run() {
        while(gameIsRunning) {
            numbersGroupForComparison.compareWith(user.inputNumbers());
        }
    }
}