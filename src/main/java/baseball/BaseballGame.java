package baseball;

import baseball.BaseballSystem.validation.InputValidationRule;
import baseball.BaseballSystem.validation.BaseballValidationImpl;
import baseball.BaseballSystem.judgement.JudgementService;
import baseball.BaseballSystem.judgement.JudgementServiceImpl;
import baseball.BaseballSystem.validation.Validation;
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
                System.out.print("숫자를 입력해주세요 : ");
                String validPlayerInput = validation.isValidInput(Console.readLine());
                Player player = new Player(validPlayerInput);
                JudgementResultDto resultDto = judgementService.matchTheNumbers(player, computer);
                isCorrect = resultDto.isCorrectAnswer();
                System.out.println(resultDto.getResultMessage());
            } while (!isCorrect);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean continueGame() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
}
