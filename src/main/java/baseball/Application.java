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
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();

            inputValidator.validateGameNumberInput(input);

            BaseballGame game = new BaseballGame(answer, input);
            game.printGameResult();

            if (game.isGameOver()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        } while (true);
    }

    private static boolean checkRestartGame(InputValidator inputValidator) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();

        inputValidator.validateRestartGameInput(input);
        return input.equals(BaseballGame.RE_GAME);
    }
}
