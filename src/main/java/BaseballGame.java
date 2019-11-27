public class BaseballGame {
    private Computer computer;
    private User user;

    public BaseballGame() {
        computer = new Computer();
        user = new User();
    }

    public void run() {
        Numbers numbersFromUser = user.inputNumbers();
        computer.compareNumbersWith(numbersFromUser);
    }
}