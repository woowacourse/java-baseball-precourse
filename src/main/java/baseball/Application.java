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

        while (manager.isGameInProgress()) {
            printer.printInputGuide();

            String inputValue = scanner.nextLine();

            Validator.validateInputValue(inputValue);

            int[] resultBallsAndStrikes = manager.getBallsAndStrikes(Converter.convertString(inputValue));

            printer.printResult(resultBallsAndStrikes);

            int strikes = resultBallsAndStrikes[1];

            if (strikes == GameManager.BASEBALL_NUMBER) {
                printer.printGameProgess();

                String progressInput = scanner.nextLine();

                Validator.validateProgressValue(progressInput);

                int progressStatusCode = Integer.parseInt(progressInput);

                manager.setGameStatus(progressStatusCode);
            }
        }
    }
}
