package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        Computer computer = new Computer(numberGenerator);
        InputValidator inputValidator = new InputValidator();

        do {
            playGame(computer, inputValidator);
        } while (true);
    }

    public static void playGame(Computer computer, InputValidator inputValidator) {
        String answer = computer.generateAnswer();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            inputValidator.isValidInput(inputString);

            BaseballGame game = new BaseballGame(answer, inputString);
            game.printGameResult();

            if (game.isGameOver()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

        } while (true);
    }
}
