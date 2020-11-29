package baseball;

import utils.Converter;
import utils.Printer;
import utils.Validator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        BaseballManager manager = new BaseballManager();
        Printer printer = new Printer();
        Validator validator = new Validator();

        while (manager.isGameInProgress()) {
            //입력 받고
            printer.printInputGuide();

            String inputValue = scanner.nextLine();

            validator.validateInputValue(inputValue);

            int[] convertedValues = Converter.convertString(inputValue);

            int ballNumber = manager.getBallNumber(convertedValues);
            int strikeNumber = manager.getStrikeNumber(convertedValues);

            printer.printResult(ballNumber, strikeNumber);

            if (validator.isGameSet(strikeNumber)) {
                printer.printGameProgess();

                String progressInput = scanner.nextLine();

                validator.validateProgressValue(progressInput);

                int progressStatusCode = Integer.parseInt(progressInput);

                manager.setGameStatus(progressStatusCode);
            }
        }
    }
}
