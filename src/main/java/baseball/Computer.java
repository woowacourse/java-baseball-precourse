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
        generateBalls();

        while (isNotAllStrike(score) || wantToRestart()) {
            Alert.enterNumber();
            this.playerBalls = player.enterNumber();
            score = NumberComparator.compareTwoBalls(
                randomBalls.getBalls(),
                playerBalls.getBalls());
            Alert.markScore(score.get(BALL), score.get(STRIKE));
        }
    }

    private boolean wantToRestart() {
        Alert.askToRestart();

        if (player.enterOrder()) {
            generateBalls();
            return true;
        }

        return false;
    }

    private boolean isNotAllStrike(Map<String, Integer> score) {
        if (score == null || score.get(STRIKE) != 3) {
            return true;
        }

        Alert.finishGame();
        return false;
    }

    private void generateBalls(){
        this.randomBalls = NumberGenerator.generateNumber();
    }

}
