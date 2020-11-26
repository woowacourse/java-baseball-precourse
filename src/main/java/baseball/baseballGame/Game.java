package baseball.baseballGame;

import com.sun.tools.jdeprscan.scan.Scan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int NUM_LENGTH = 3;
    private List<Integer> answer = new ArrayList<>(NUM_LENGTH);
    private List<Integer> playerAnswer = new ArrayList<>(NUM_LENGTH);
    private Computer computer;
    private Scanner scanner;

    public Game(Scanner scanner) {
        computer = new Computer();
        this.scanner = scanner;
       // computer.makeAnswer(answer, NUM_LENGTH);
    }

    public void start() {
        Player player = new Player(scanner);

        playerAnswer = player.inputNumber(NUM_LENGTH);

    }
}
