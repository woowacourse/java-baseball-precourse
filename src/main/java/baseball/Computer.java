package baseball;

import java.util.Map;
import java.util.Scanner;

public class Computer {
    private static final String BALL = "ball";
    private static final String STRIKE = "strike";

    private Balls randomBalls;
    private Balls playerBalls;
    private Player player;

    public Computer(Scanner scanner) {
        this.player = new Player(scanner);
    }

    public void startGame() {
        Map<String, Integer> score = null;

        this.randomBalls = NumberGenerator.generateNumber();
        Alert.enterNumber();
        this.playerBalls = player.enterNumber();
        score = NumberComparator.compareTwoBalls(
            randomBalls.getBalls(), playerBalls.getBalls());
        Alert.markScore(score.get(BALL),score.get(STRIKE));



    }


}
