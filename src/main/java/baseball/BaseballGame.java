package baseball;

import java.util.List;

public class BaseballGame {

    private final BaseballRandomNumberGenerator randomNumberGenerator;
    private final BaseballGameInput input;
    private final BaseballGameHint gameHint;
    private final BaseballGameResult result;

    public BaseballGame() {
        this.randomNumberGenerator = new BaseballRandomNumberGenerator();
        this.input = new BaseballGameInput();
        this.gameHint = new BaseballGameHint();
        this.result = new BaseballGameResult();
    }

    public void run() {
        do {
            play();
        } while (input.isContinue());
    }

    public void play() {
        List<Integer> computer = randomNumberGenerator.generateRandomNumber();
        String hint;

        do {
            List<Integer> player = input.inputNumber();

            hint = gameHint.generateHint(computer, player);
            System.out.println(hint);
        } while (!result.checkRightAnswer(hint));
    }
}
