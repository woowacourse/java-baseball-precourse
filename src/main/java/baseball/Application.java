package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        Computer computer = new Computer(numberGenerator);
        InputValidator inputValidator = new InputValidator();
        Game game = new Game(computer, inputValidator);

        do {
            game.playGame();
        } while (checkRestartGame(inputValidator));
    }

    private static boolean checkRestartGame(InputValidator inputValidator) {
        System.out.println(GameConstant.RESTART_MESSAGE);
        String input = Console.readLine();

        inputValidator.validateRestartGameInput(input);
        return input.equals(GameConstant.RE_GAME);
    }
}
