package baseball.game;

import baseball.NumbersConstraints;
import baseball.PromptMessage;
import baseball.utils.NumberListGenerator;
import baseball.utils.UserInputHandler;

public class BaseballGame {

    private final TargetNumber targetNumber;
    private boolean isRunning;

    public BaseballGame() {
        this.targetNumber = new TargetNumber(
            NumberListGenerator.generateNonDuplicateNumbers(
                NumbersConstraints.NUMBER_LENGTH.value(),
                NumbersConstraints.MIN_NUMBER.value(),
                NumbersConstraints.MAX_NUMBER.value()
            ));
        this.isRunning = true;
    }

    public void play() {
        while (isRunning) {
            proceedTurn();
        }
        System.out.println(PromptMessage.GAME_OVER_MESSAGE.message());
    }

    private void proceedTurn() {
        BaseballGameTurn turn = new BaseballGameTurn(getUserExpectation(), targetNumber);
        System.out.println(turn.getResultMessage());
        checkGameEnded(turn);
    }

    private UserExpectation getUserExpectation() {
        return new UserExpectation(
            UserInputHandler.getNumbersList(PromptMessage.USER_EXPECTATION_PROMPT.message())
        );
    }

    private void checkGameEnded(BaseballGameTurn turn) {
        if (turn.isNumberEqual()) {
            this.isRunning = false;
        }
    }
}
