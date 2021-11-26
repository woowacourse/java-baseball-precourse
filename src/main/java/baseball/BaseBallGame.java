package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public void start() {
        String targetNumber = NumberGenerator.generate();
        System.out.println(targetNumber);
        getInputUntilCorrectAnswer(targetNumber);

        configureRestartGame();
    }

    private void getInputUntilCorrectAnswer(String targetNumber) {
        String inputNumber = "";

        while (!inputNumber.equals(targetNumber)) {
            inputNumber = getBaseBallInput();
            printHint(targetNumber, inputNumber);
        }
    }

    private void configureRestartGame() {
        String restart = getRestartInput();
        BaseBallValidator.validateRestart(restart);

        if (restart.equals("1")) {
            start();
        }
    }

    private String getRestartInput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return  Console.readLine();
    }

    private void printHint(String targetNumber, String inputNumber) {
        BaseBallHint hint = calculateHint(targetNumber, inputNumber);
        System.out.println(hint);
    }

    private BaseBallHint calculateHint(String target, String input) {
        BaseBallHint result = new BaseBallHint();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target.charAt(i)) {
                result.strikeCount++;
            } else if (target.contains(String.valueOf(input.charAt(i)))) {
                result.ballCount++;
            }
        }
        return result;
    }

    private String getBaseBallInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        BaseBallValidator.validateBaseBallInput(input);
        return input;
    }
}
