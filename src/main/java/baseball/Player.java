package baseball;

import java.util.List;

public class Player {

    public Player() {

    }

    public List<Integer> submitAnswer() {
        Output playerOutput = new Output();
        playerOutput.printAnswerRequest();

        Input playerInput = new Input();
        return playerInput.inputPlayerAnswer();
    }

    public boolean askForMore() {
        Output playerOutput = new Output();
        playerOutput.printAskMore();

        Input playerInput = new Input();
        return playerInput.anotherRound();
    }
}
