package baseball;

public class Game {

    private final Computer computer;
    private final Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void run() {
        computer.createRandomBalls();
        player.makeBalls();

        computer.makeJudge(player.getBalls());
        if (computer.gameFinished(player.getBalls())) {
            System.out.println("게임 종료");
        }
    }

}
