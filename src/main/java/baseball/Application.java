package baseball;

import utils.Converter;
import utils.Printer;
import utils.Validator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameManager manager = new GameManager();
        Printer printer = new Printer();
        Validator validator = new Validator();

        while (manager.isGameInProgress()) {
            printer.printInputGuide();

            String inputValue = scanner.nextLine();

            validator.validateInputValue(inputValue);

            int[] resultBallsAndStrikes = manager.getBallsAndStrikes(Converter.convertString(inputValue));

            printer.printResult(resultBallsAndStrikes);

            if (validator.isGameSet(resultBallsAndStrikes)) {
                printer.printGameProgess();

                String progressInput = scanner.nextLine();

                validator.validateProgressValue(progressInput);

                int progressStatusCode = Integer.parseInt(progressInput);

                manager.setGameStatus(progressStatusCode);
            }
        }
    }
}
