package baseballgame;

import baseballgame.io.InputBaseballGame;
import baseballgame.io.OutputBaseballGame;
import baseballgame.system.BaseballGameSystem;

public class BaseballGameApplication {
    public static void main(String[] args) {
        int nextStep;

        do {
            startNewGame();
            OutputBaseballGame.printFinishMsg();
            nextStep = InputBaseballGame.inputNextStep();
        } while (nextStep == 1);
    }

    public static void startNewGame() {
        int userNumber, strikeCount;
        BaseballGameSystem game = new BaseballGameSystem();

        do {
            userNumber = InputBaseballGame.inputUserNumber();
            game.initPitchCount();
            game.checkAnswer(userNumber);
            strikeCount = game.getStrikeCount();
        } while (strikeCount != 3);
    }
}
