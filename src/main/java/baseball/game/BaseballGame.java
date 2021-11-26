package baseball.game;

import baseball.NumbersConstraints;
import baseball.PromptMessage;
import baseball.utils.NumberListGenerator;
import baseball.utils.UserInputHandler;

public class BaseballGame {

    private final TargetNumber targetNumber;

    public BaseballGame() {
        this.targetNumber = new TargetNumber(
            NumberListGenerator.generateNonDuplicateNumbers(
                NumbersConstraints.NUMBER_LENGTH.value(),
                NumbersConstraints.MIN_NUMBER.value(),
                NumbersConstraints.MAX_NUMBER.value()
            ));
    }

    public void play() {
        boolean running = true;
        BaseballGameTurn turn;

        while (running) {
            turn = proceedTurn();
            System.out.println(turn.getResultMessage());
            running = isGameStillRunning(turn);
        }
    }

    private BaseballGameTurn proceedTurn() {
        return new BaseballGameTurn(getUserExpectation(), targetNumber);
    }

    private UserExpectation getUserExpectation() {
        return new UserExpectation(
            UserInputHandler.getNumbersList(PromptMessage.USER_EXPECTATION_PROMPT.message())
        );
    }

    private boolean isGameStillRunning(BaseballGameTurn turn) {
        if (turn.isGameEnded()) {
            System.out.println(PromptMessage.GAME_OVER_MESSAGE.message());
            return false;
        }
        return true;
    }
}
