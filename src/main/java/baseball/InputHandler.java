package baseball;

import utils.InputUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> getNumbers() {
        String input = getInput("숫자를 입력해주세요 : ", false);
        InputUtils.validateUserInputForNumbers(input);
        return parse(input);
    }

    public boolean restart() {
        String input = getInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ", true);
        InputUtils.validateUserInputForRestart(input);
        if (input.equals("1")) {
            return true;
        }
        return false;
    }

    private String getInput(String inputInstruction, boolean withLn) {
        if (withLn) {
            System.out.println(inputInstruction);
        }
        System.out.print(inputInstruction);
        return this.scanner.nextLine();
    }

    private List<Integer> parse(String input) {
        List<Integer> parsed = new ArrayList<>();
        for (int i = 0; i < InputUtils.digit(); i++) {
            parsed.add(Integer.parseInt(input.substring(i, i+1)));
        }
        return parsed;
    }
}
