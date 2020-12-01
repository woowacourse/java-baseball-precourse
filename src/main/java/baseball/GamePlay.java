package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {
    private final Scanner scanner;
    private ArrayList<Integer> targetNumber;
    private TargetNumberGenerator targetNumberGenerator;
    private Player player;
    private Hint hint;

    public GamePlay(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        do {
            setTargetNumber();
            setPlayer();
            setHint(targetNumber);
            playGame();
        }
        while (player.getIfContinue());
    }

    private void setTargetNumber() {
        targetNumberGenerator = new TargetNumberGenerator();
        this.targetNumber = targetNumberGenerator.getTargetNumber();
    }

    private void setPlayer() {
        this.player = new Player(scanner);
    }

    private void setHint(ArrayList<Integer> targetNum) {
        this.hint = new Hint(targetNum);
    }

    private void playGame() {
        boolean success = false;
        ArrayList<Integer> playerNumber;
        while (!success) {
            playerNumber = player.getInputNumber();
            String givenHint = hint.getHint(playerNumber);
            System.out.println(givenHint);
            success = hint.getResult();
        }
    }
}
