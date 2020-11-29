package baseball;

import utils.Converter;
import utils.Printer;
import utils.Validator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameManager manager = new GameManager();

        while (manager.isGameInProgress()) {
            System.out.print("숫자를 입력해주세요 : ");

            String inputValue = scanner.nextLine();

            Validator.validateInputValue(inputValue);

            int[] resultBallsAndStrikes = manager.getBallsAndStrikes(Converter.convertString(inputValue));

            System.out.println(Printer.getResultString(resultBallsAndStrikes));
        }
    }
}
