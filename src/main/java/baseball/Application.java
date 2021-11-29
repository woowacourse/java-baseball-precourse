package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private final static int DIGIT = 3;
    private final static int CORRECT_NOTING = 0;

    public static void main(String[] args) {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Printer printer = new Printer();
        Validator validator = new Validator();

        String randomNumber = String.valueOf(randomNumberGenerator.makeRandomNumber(DIGIT));
        System.out.println(randomNumber);
        Result result = new Result(randomNumber);

        while (true) {
            printer.printNumberInputMessage();
            String input = Console.readLine();
            validator.validateInputNumber(input);

            result.makeResult(input);
            int ball = result.getBall();
            int strike = result.getStrike();

            if (ball == CORRECT_NOTING && strike == CORRECT_NOTING) {
                printer.printResultNoting();
            }

            if (ball != CORRECT_NOTING) {
                printer.printResultBall(ball);
            }

            if (strike != CORRECT_NOTING) {
                printer.printResultStrike(strike);
            }

            if (strike == DIGIT) {
                printer.printResultGameEnd();
                break;
            }

        }

    }
}
