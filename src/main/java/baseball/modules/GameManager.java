package baseball.modules;

import java.util.Scanner;

/**
 * Manages the overall flow of the game.
 * 
 * @author Kim Hanseul
 */
public class GameManager {
    private static final int NUMBER_SIZE = 3;
    private static final int ANSWER_YES = 1;

    private InputOutputManager inputOutputManager;
    private NumberGenerator numberGenerator;

    private int strike = 0;
    private int ball = 0;

    public GameManager(final Scanner scanner) {
        if (ExceptionChecker.isNull(scanner)) {
            throw new IllegalArgumentException();
        }

        inputOutputManager = new InputOutputManager(scanner, NUMBER_SIZE);
        numberGenerator = new NumberGenerator(NUMBER_SIZE);
    }

    /** Run the game. */
    public void run() {
        numberGenerator.generate();

        playOneRound();
    }

    private void playOneRound() {
        int[] generatedNumber = numberGenerator.getNumber();
        int[] inputNumber = inputOutputManager.askUserInputNumber();

        compareForRoundResult(inputNumber, generatedNumber);
        inputOutputManager.printRoundResult(strike, ball);

        handleRoundEnd();
    }

    private void compareForRoundResult(final int[] inputNumber, final int[] generatedNumber) {
        if (ExceptionChecker.isNull(inputNumber) || ExceptionChecker.isNull(generatedNumber)) {
            throw new IllegalArgumentException();
        }

        if (inputNumber.length != generatedNumber.length) {
            throw new IllegalArgumentException();
        }

        strike = 0;
        ball = 0;

        for (int i = 0; i < inputNumber.length; i++) {
            if (inputNumber[i] == generatedNumber[i]) {
                strike++;
                continue;
            }

            if (IntegerArrayUtils.isContains(generatedNumber, inputNumber[i])) {
                ball++;
            }
        }
    }

    private void handleRoundEnd() {
        if (isWin()) {
            doItWhenGameWin();
            return;
        }

        // 숫자를 모두 맞추지 못했다면 다시 한 라운드 시작
        playOneRound();
    }

    private boolean isWin() {
        return strike == NUMBER_SIZE;
    }

    private void doItWhenGameWin() {
        inputOutputManager.printWinMessage();
        int answer = inputOutputManager.askRestartGame();
        if (answer == ANSWER_YES) {
            run();
        }
        
        // 재시작하지 않으면 게임 종료
    }
}
