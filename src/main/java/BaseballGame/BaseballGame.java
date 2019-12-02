package BaseballGame;

public class BaseballGame {
    private NumbersGroup answerNumbers;
    private User user;

    public BaseballGame() {
        this.answerNumbers = NumbersGroup.makeNumbersRandomly();
        this.user = new User();
    }

    public void run() {
        ComparedResult comparedResult;
        do {
            comparedResult = answerNumbers.compareWith(user.inputNumbers());
            comparedResult.printMessage();
        } while (comparedResult.isGameRunning());
    }

    public boolean restart() {
        return user.askIfRestart();
    }
}