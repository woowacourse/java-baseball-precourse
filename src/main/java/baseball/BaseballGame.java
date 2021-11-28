package baseball;
import camp.nextstep.edu.missionutils.Console;

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
        return checkRestart();
    }
    private boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            return false;
        } else if (input == 2) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
