package baseball.game;

import baseball.constants.GameMessages;
import baseball.constants.NumberListConstraints;
import baseball.domain.TargetNumber;
import baseball.domain.UserExpectation;
import baseball.utils.NumberListGenerator;
import baseball.utils.UserInputHandler;

public class BaseballGame {

    private final TargetNumber targetNumber;
    private boolean isRunning;

    public BaseballGame() {
        this.targetNumber = new TargetNumber(
            NumberListGenerator.generateNonDuplicateNumbers(
                NumberListConstraints.LIST_LENGTH.value(),
                NumberListConstraints.MIN_NUMBER.value(),
                NumberListConstraints.MAX_NUMBER.value()
            ));
        this.isRunning = true;
    }

    public void play() {
        while (isRunning) {
            proceedTurn();
        }
        System.out.println(GameMessages.OUT_GAME_OVER);
    }

    private void proceedTurn() {
        BaseballGameTurn turn = new BaseballGameTurn(getUserExpectation(), targetNumber);
        System.out.println(turn.getResultMessage());
        checkGameEnded(turn);
    }

    private UserExpectation getUserExpectation() {
        return new UserExpectation(
            UserInputHandler.getNumbersList(GameMessages.PROMPT_USER_EXPECTATION)
        );
    }

    private void checkGameEnded(BaseballGameTurn turn) {
        if (turn.isNumberEqual()) {
            this.isRunning = false;
        }
    }
}
