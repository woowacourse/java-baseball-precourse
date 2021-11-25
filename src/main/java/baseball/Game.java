package baseball;

import java.util.List;

public class Game {

    Examiner examiner = new Examiner();
    GameExecutor gameExecutor = new GameExecutor();
    List<Integer> userInputNumberList;
    boolean wantReply = true;

    public void play() {
        int strikeCount = 0;
        int ballCount = 0;

        examiner.init();

        while (wantReply) {
            userInputNumberList = gameExecutor.getUserAnswer();
            if (examiner.isNothing(userInputNumberList)) {
                gameExecutor.printNothing();
            } else {
                strikeCount = examiner.countStrike(userInputNumberList);
                ballCount = examiner.countBall(userInputNumberList);
                gameExecutor.printScore(strikeCount, ballCount);
            }
            if (examiner.isCorrect(userInputNumberList)) {
                gameExecutor.printCorrect();
                selectOption(gameExecutor.getUserSelection());
            }
        }
    }

    private void selectOption(int selection) {
        if (selection == 1) {
            examiner.generateNewNumberList();
        } else if (selection == 2) {
            wantReply = false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
