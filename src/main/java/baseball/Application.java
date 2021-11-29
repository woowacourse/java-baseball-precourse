package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        Computer computer = new Computer(numberGenerator);
        InputValidator inputValidator = new InputValidator();

        do {
            playGame(computer, inputValidator);
        } while (checkRestartGame(inputValidator));
    }

    public static void playGame(Computer computer, InputValidator inputValidator) {
        String answer = computer.generateAnswer();
        do {
            System.out.print(GameConstant.INPUT_MESSAGE);
            String input = readLine();

            inputValidator.validateGameNumberInput(input);

            BaseballGame game = new BaseballGame(answer, input);
            game.printGameResult();

            if (game.isGameOver()) {
                System.out.println(GameConstant.GAME_OVER_MESSAGE);
                break;
            }
        } while (true);
    }

    private static boolean checkRestartGame(InputValidator inputValidator) {
        System.out.println(GameConstant.RESTART_MESSAGE);
        String input = readLine();

        inputValidator.validateRestartGameInput(input);
        return input.equals(GameConstant.RE_GAME);
    }
}
