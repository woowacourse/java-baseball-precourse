package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private final int AGAIN = 1;
    private Scanner in;
    
    public Input() {
        in = new Scanner(System.in);
    }

    public List<Integer> inputPlayerAnswer() {
        List<Integer> playerAnswer = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            playerAnswer.add(in.nextInt());
        }
        return playerAnswer;
    }

    public boolean anotherRound() {
        int playerDecision = in.nextInt();
        return playerDecision == AGAIN;
    }
}
