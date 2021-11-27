package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Computer computer;
    private final UserInput userInput;
    private final Score score;

    public BaseballGame() {
        this.computer = new Computer();
        this.userInput = new UserInput();
        this.score = new Score();
    }

    public void start() {
        do {
            computer.setAnswer();
            play();
        } while (is_restart());
    }

    private void play() {
        do {
            userInput.setInput();
            score.grade(computer.getAnswer(), userInput.getInput());
            score.printResult();
            score.setZero();
        } while (!score.is_success(computer.getAnswer(), userInput.getInput()));

        printSuccess();
    }

    private boolean is_restart() {
        System.out.println(Constant.RESTART_OR_EXIT);
        String restart_or_exit = Console.readLine();
        Validation.isValidRestart(restart_or_exit);

        if (restart_or_exit.charAt(0) - '0' == Constant.RESTART_VALUE) {
            return true;
        } else if (restart_or_exit.charAt(0) - '0' == Constant.EXIT_VALUE) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void printSuccess() {
        System.out.println(Constant.SUCCESS);
    }

}
