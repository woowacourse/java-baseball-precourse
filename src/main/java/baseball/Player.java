package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private final int AGAIN = 1;
    private final int TERMINATE = 2;

    public Player() {

    }

    public List<Integer> submitAnswer() {
        Scanner in = new Scanner(System.in);
        List<Integer> playerAnswer = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            playerAnswer.add(in.nextInt());
        }
        return playerAnswer;
    }

    public boolean askForMore() {
        Scanner in = new Scanner(System.in);
        int decision = in.nextInt();
        return decision == AGAIN;
    }
}
