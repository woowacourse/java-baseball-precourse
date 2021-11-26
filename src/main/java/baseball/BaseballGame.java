package baseball;

import java.util.List;

public class BaseballGame {

    private final BaseballRandomNumberGenerator randomNumberGenerator;
    private final BaseballGameInput gameInput;
    private final BaseballGameHint gameHint;
    private final BaseballGameResult gameResult;

    public BaseballGame() {
        this.randomNumberGenerator = new BaseballRandomNumberGenerator();
        this.gameInput = new BaseballGameInput();
        this.gameHint = new BaseballGameHint();
        this.gameResult = new BaseballGameResult();
    }

    public void run() {
        do {
            play();
        } while (gameInput.isContinue());
    }

    private void play() {
        List<Integer> computer = randomNumberGenerator.generateRandomNumber();
        String hint;

        do {
            List<Integer> player = gameInput.inputNumber();

            hint = gameHint.generateHint(computer, player);
            System.out.println(hint);
        } while (!gameResult.checkRightAnswer(hint));
    }
}
