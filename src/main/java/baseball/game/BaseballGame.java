package baseball.game;

import baseball.baseballsystem.SystemMessage;
import baseball.baseballsystem.validation.InputValidationRule;
import baseball.baseballsystem.validation.BaseballValidationImpl;
import baseball.baseballsystem.judgement.JudgementService;
import baseball.baseballsystem.judgement.JudgementServiceImpl;
import baseball.baseballsystem.validation.Validation;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.dto.response.JudgementResultDto;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private static final boolean OK = true;
    private static final boolean NO = false;

    private final Validation validation;
    private final JudgementService judgementService;

    public BaseballGame() {
        validation = BaseballValidationImpl.getInstance();
        judgementService = JudgementServiceImpl.getInstance();
    }

    public void play() {
        do {
            start();
        } while (continueGame());
    }

    private void start() {
        boolean isCorrect = true;
        try {
            Computer computer = new Computer();
            do {
                printMessage(SystemMessage.NUMBER_INPUT_MESSAGE.getMessage());
                String validPlayerInput = validation.isValidInput(Console.readLine());
                Player player = new Player(validPlayerInput);
                JudgementResultDto resultDto = judgementService.matchTheNumbers(player, computer);
                isCorrect = resultDto.isCorrectAnswer();
                printMessage(resultDto.getResultMessage());
            } while (!isCorrect);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean continueGame() {
        try {
            printMessage(SystemMessage.CORRECT_ANSWER_NEXT_MESSAGE.getMessage());
            String validContinuePlayerInput = validation.isValidContinueInput(Console.readLine());
            return isContinue(validContinuePlayerInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContinue(String continuePlayerInput) {
        if (InputValidationRule.CONTINUE_GAME.getValue().equals(continuePlayerInput)) {
            return OK;
        } else {
            return NO;
        }
    }

    private void printMessage(final String message) {
        System.out.println(message);
    }
}
