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

            int strikes = resultBallsAndStrikes[1];

            System.out.println(Printer.getResultString(resultBallsAndStrikes));

            if (strikes == GameManager.BASEBALL_NUMBER) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String progressInput = scanner.nextLine();

                Validator.validateProgressValue(progressInput);

                int progressStatusCode = Integer.parseInt(progressInput);

                manager.setGameStatus(progressStatusCode);
            }
        }
    }
}
