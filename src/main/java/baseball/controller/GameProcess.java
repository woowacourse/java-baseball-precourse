package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.viewer.OutputShower;

public class GameProcess {
    public void play() {
        boolean oneMoreGame = false;
        Computer computer = new Computer();
        User user = new User();
        do {
            initateRandomSet(computer);
            oneGamePlay(user, computer);
            oneMoreGame = askMoreGame();
        } while (!oneMoreGame);
    }

    private void initateRandomSet(Computer computer) {
        computer.setBallBunch(RandomBallSet.ballSet());
    }

    private void oneGamePlay(User user, Computer computer) {
        boolean endGame = false;
        do {
            user.setBallBunch(InputReceiver.userAnswer());
            RuleChecker.gradePoints(user, computer);
            OutputShower.outputPrint(user);
            endGame = passAnswerHurdle(user);
        } while (!endGame);
    }

    private boolean askMoreGame() {
        OutputShower.askRestart();
        boolean askOneMore = InputReceiver.askEndGames();
        return askOneMore;
    }

    private boolean passAnswerHurdle(User user) {
        boolean passResult = false;
        int points = user.getStrikeNumber();
        if (points == 3) {
            passResult = true;
        }

        return passResult;
    }


}