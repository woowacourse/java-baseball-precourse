public class BaseballGame {
    private Numbers numbersForComparison;
    private User user;
    private boolean gameIsRunning;

    public BaseballGame() {
        numbersForComparison = new Numbers();
        user = new User();
        gameIsRunning = true;
    }

    public void run() {
        while(gameIsRunning) {
            numbersForComparison.compareWith(user.inputNumbers());
        }
    }


}