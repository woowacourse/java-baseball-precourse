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
            inputNumber = getConsoleInput();
            printHint(targetNumber, inputNumber);
        }
    }

    private void configureRestartGame() {
        String restart = getRestartInput();
        validateRestart(restart);

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

    private String getConsoleInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) throws IllegalArgumentException {
        if (input.length() != 3 || !isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateRestart(String input) throws IllegalArgumentException {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }

        int i = Integer.parseInt(input);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
    }
}
