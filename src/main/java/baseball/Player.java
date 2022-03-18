package baseball;

import java.util.List;

public class Player {

    private Output playerOutput;
    private Input playerInput;

    public Player() {
        playerOutput = new Output();
        playerInput = new Input();
    }

    public List<Integer> submitAnswer() {
        playerOutput.printAnswerRequest();
        return playerInput.inputPlayerAnswer();
    }

    public boolean askForMore() {
        playerOutput.printAskMore();
        return playerInput.anotherRound();
    }
}
