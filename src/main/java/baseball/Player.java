package baseball;

import java.util.List;

public class Player {

    public Player() {

    }

    public List<Integer> submitAnswer() {
        Input playerInput = new Input();
        return playerInput.inputPlayerAnswer();
    }

    public boolean askForMore() {
        Input playerInput = new Input();
        return playerInput.anotherRound();
    }
}
