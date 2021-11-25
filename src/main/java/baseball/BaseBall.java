package baseball;

public class BaseBall {
    private Computer computer;
    private Player player;

    public BaseBall() {
        computer = new Computer();
        player = new Player();
    }

    public void playGame(){
        computer.decideRandomNumber();
        int predict = player.predictNumber();

    }
}
