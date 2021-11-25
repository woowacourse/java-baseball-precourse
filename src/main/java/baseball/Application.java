package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Printer printer = new Printer();
        Validator validator = new Validator();

        String randomNumber = String.valueOf(randomNumberGenerator.makeRandomNumber(3));

        while (true) {
            printer.printNumberInputMessage();
            String input = Console.readLine();
            validator.validateInputNumber(input);


        }

    }
}
