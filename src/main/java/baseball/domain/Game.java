package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";
    private static final String NOT_NUMBER_INVALID_ONE_OR_TWO = "1 혹은 2의 입력이 아닌 올바르지 않은 입력입니다.";
    private BaseballNums answerBaseballNums;
    private BaseballNums playerBaseballNums;
    private GameResult gameResult;

    public void processRun() {
        processInit();
        do {
            processPlay();
        } while (gameResult.isValidateWinner());
        OutputView.showGameResultMessage();
        processResume();
    }

    public void processInit() {
        gameResult = new GameResult();
        answerBaseballNums = BaseballNumsGenerator.generateRandomBaseballNums();
    }

    public void processPlay() {
        playerBaseballNums = BaseballNumsGenerator.generateInputBaseballNums(InputView.inputBaseballNumbers());
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        OutputView.showHintMessage(gameResult);
    }

    public void processResume() {
        String inputMessage = InputView.inputResumeOrEnd();

        if (inputMessage.equals(RESTART_GAME)) {
            processRun();
            return;
        }
        if (inputMessage.equals(END_GAME)) {
            return;
        }
        throw new IllegalArgumentException(NOT_NUMBER_INVALID_ONE_OR_TWO);
    }
}