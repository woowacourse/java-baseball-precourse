package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final static int DIGIT = 3;
    private final static int CORRECT_NOTHING = 0;

    public int run() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Printer printer = new Printer();
        Validator validator = new Validator();

        String randomNumber = String.valueOf(randomNumberGenerator.makeRandomNumber(DIGIT));
        Result result = new Result(randomNumber);

        while (true) {
            printer.printNumberInputMessage();
            String input = Console.readLine();
            validator.validateInputNumber(input);

            result.makeResult(input);
            int ball = result.getBall();
            int strike = result.getStrike();

            if (ball == CORRECT_NOTHING && strike == CORRECT_NOTHING) {
                printer.printResultNoting();
            }

            if (ball != CORRECT_NOTHING && strike != CORRECT_NOTHING) {
                printer.printResultBall(ball);
            }

            if (ball != CORRECT_NOTHING && strike == CORRECT_NOTHING) {
                printer.printResultBall(ball);
                System.out.println();
            }

            if (strike != CORRECT_NOTHING) {
                printer.printResultStrike(strike);
            }

            if (strike == DIGIT) {
                printer.printResultGameEnd();
                break;
            }

        }

        printer.printGameRestart();
        String isRestart = Console.readLine();
        validator.validateRestartInput(isRestart);

        return Integer.parseInt(isRestart);
    }

}
