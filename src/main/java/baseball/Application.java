package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        Computer computer = new Computer(numberGenerator);
        InputValidator inputValidator = new InputValidator();

        playGame(computer, inputValidator);
    }

    public static void playGame(Computer computer, InputValidator inputValidator) {
        String answer = computer.generateAnswer();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            inputValidator.isValidInput(inputString);
        } while (true);
    }
}
