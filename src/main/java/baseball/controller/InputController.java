package baseball.controller;

import baseball.domain.GameStatus;
import baseball.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputController {

    private static Scanner scanner;

    private static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public InputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> input() {

        printInputMessage();

        String input = scanner.nextLine();

        try {
            Validator.validateInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return input();
        }

        return toIntegerList(input);
    }

    private void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    private List<Integer> toIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public GameStatus inputRestart() {
        ConsoleView.printRestart();
        String input = scanner.nextLine();

        try {
            Validator.validateRestart(input);
        } catch (IllegalArgumentException e) {
            return inputRestart();
        }

        int restart = Integer.parseInt(input);

        if (restart == Validator.COMMAND_RESTART) {
            return GameStatus.RESTART;
        }
        return GameStatus.END;

    }
}
