package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private final int AGAIN = 1;
    
    public Input() {
    }

    public List<Integer> inputPlayerAnswer() {
        String playerAnswer = Console.readLine();

        List<Integer> playerAnswerList = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            int num = playerAnswer.charAt(i) - '0';
            playerAnswerList.add(num);
        }
        return playerAnswerList;
    }

    public boolean anotherRound() {
        String num = Console.readLine();
        int playerResponse = num.charAt(0) - '0';
        return playerResponse == AGAIN;
    }
}
