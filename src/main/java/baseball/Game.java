package baseball;

import baseball.viewer.OutputShower;

public class Game {
    static final int STRIKEPOSITION = 0;
    static final int BALLPOSITION = 1;
    static final int ENDGAME = 3;

    public void play() {
        boolean oneMoreGame = false;
        do {
            int[] gameSet = initateGameSet();
            oneGamePlay(gameSet);
            oneMoreGame = askMoreGame();
        } while (!oneMoreGame);
    }

    private int[] initateGameSet() {
        int[] iniateGameSet = RandomBallSet.ballSet();
        return iniateGameSet;
    }

    private void oneGamePlay(int[] gameSet) {
        boolean endGame = false;
        do {
            int[] userTryingAnswer = InputReceiver.userAnswer();
            int[] gradeResult = RuleChecker.gradePoints(userTryingAnswer, gameSet);
            int strikePoints = gradeResult[STRIKEPOSITION];
            int ballPoints = gradeResult[BALLPOSITION];
            OutputShower.outputPrint(strikePoints, ballPoints);
            endGame = passAnswerHurdle(strikePoints);
        } while (!endGame);
    }

    private boolean askMoreGame() {
        OutputShower.askRestart();
        boolean askOneMore = InputReceiver.askEndGames();
        return askOneMore;
    }

    private boolean passAnswerHurdle(int points) {
        boolean passResult = false;

        if (points == 3) {
            passResult = true;
        }

        return passResult;
    }


}