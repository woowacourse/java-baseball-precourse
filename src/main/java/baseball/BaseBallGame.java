package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private String targetNumber;
    private static final String BASEBALL_INPUT_REQUEST_TEXT = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_REQUEST_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void start() {
        generateTarget();
        System.out.println(targetNumber);
        requestInputUntilCorrectAnswer();
        configureRestartGame();
    }

    private void restart() {
        start();
    }

    private void generateTarget() {
        targetNumber = NumberGenerator.generate();
    }

    private void requestInputUntilCorrectAnswer() {
        String inputNumber = "";

        while (!inputNumber.equals(targetNumber)) {
            inputNumber = requestBaseBallInput();
            printCalculatedHint(inputNumber);
        }
    }

    private void configureRestartGame() {
        String restart = requestRestartInput();
        BaseBallValidator.validateRestart(restart);

        if (RestartInput.byNumber(restart) == RestartInput.RESTART) {
            restart();
        }
    }

    private void printCalculatedHint(String inputNumber) {
        BaseBallHint hint = calculateHint(inputNumber);
        System.out.println(hint);
    }

    private BaseBallHint calculateHint(String input) {
        BaseBallHint result = new BaseBallHint();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == targetNumber.charAt(i)) {
                result.strikeCount++;
            } else if (targetNumber.contains(String.valueOf(input.charAt(i)))) {
                result.ballCount++;
            }
        }
        return result;
    }

    private String requestBaseBallInput() {
        System.out.print(BASEBALL_INPUT_REQUEST_TEXT);
        String input = Console.readLine();
        BaseBallValidator.validateBaseBallInput(input);
        return input;
    }

    private String requestRestartInput() {
        System.out.println(RESTART_INPUT_REQUEST_TEXT);
        return Console.readLine();
    }
}
