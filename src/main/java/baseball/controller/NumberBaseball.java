package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.viewer.OutputShower;

public class NumberBaseball {
    /* 게임 진행을 명령하는 메서드*/
    public void play() {
        boolean oneMoreGame;
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
        boolean endGame ;
        do {
            user.setBallBunch(InputReceiver.userAnswer());
            RuleChecker.gradePoints(user, computer);
            OutputShowSelector.outputPrint(user);
            endGame = passAnswerHurdle(user);
        } while (!endGame);
    }

    private boolean askMoreGame() {
        OutputShower.askRestart();
        return InputReceiver.askEndGames();
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