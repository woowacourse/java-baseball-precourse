package baseball;

import constant.SystemMessage;


public class BaseBall {
    private Computer computer;
    private Player player;

    public BaseBall() {
        computer = new Computer();
        player = new Player();
    }

    public void playGame() {
        computer.decideRandomNumber();
        int predict = SystemMessage.FIRST_VALUE;
        do {
            predict = player.predictNumber();
        } while (!computer.canFinish(predict));
        System.out.printf("%s\n", SystemMessage.END_GAME_MESSAGE);
    }
}
