package baseball;

public class BaseballGame {

    public BaseballGame() {

    }

    public boolean start() {
        boolean games = false;
        Computer computer = new Computer();
        User user = new User();
        char[] number = computer.pickNumber();
        while (!games) {
            System.out.print("숫자를 입력해주세요 : ");
            char[] users = user.userInput();
            games = computer.compare(users, number);
        }
    }
    private boolean checkRestart() {

    }
}
