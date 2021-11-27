package baseball;

import java.util.List;

// 숫자야구의 전반적인 운영을 담당하는 클래스
public class Game {

    Computer computer;
    User user;

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void start() {
        while (true) {
            List<Integer> gameReply = user.askReply();
            user.replyValidation();
            boolean isCorrect = computer.matchAnswer(gameReply);
            computer.printResult();

            if (isCorrect && user.askExit()) {
                break;
            }
            if (isCorrect) {
                computer.setNewGame();
            }
        }
    }
}
