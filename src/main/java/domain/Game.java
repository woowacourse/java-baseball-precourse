package domain;

import ui.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private static final int RESTART_GAME = 1;
    private static final int EXIT_GAME = 2;
    private List<Integer> inputBalls;
    private Balls balls;
    private Computer computer;
    private boolean isStartingGame;
    private boolean isCorrectAnswer;

    public void startGame(Scanner scanner) {
        try {
            tryToStartGame(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private void tryToStartGame(Scanner scanner) {
        isStartingGame = true;
        while (isStartingGame) {
            playOneGame(scanner);
        }
    }

    private void playOneGame(Scanner scanner) {
        computer = new Computer();
        isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            enterNumber(scanner);
        }
        checkIfRestartGame(scanner);
        // nextInt() 뒤에 nextLine()이 올 경우 개행 문자가 남아 있어서 입력되는 에러를 방지하기 위한 코드
        scanner.nextLine();
    }

    private void enterNumber(Scanner scanner) {
        try {
            String userInput = Input.receiveNumberInput(scanner);
            validateInteger(userInput);
            inputBalls = Arrays.stream(userInput.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
            balls = new Balls(inputBalls);
            isCorrectAnswer = computer.isCorrectAnswer(inputBalls);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            enterNumber(scanner);
        }
    }

    private void checkIfRestartGame(Scanner scanner) {
        try {
            isStartingGame = tryToCheckIfRestartGame(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            checkIfRestartGame(scanner);
        }
    }

    private boolean tryToCheckIfRestartGame(Scanner scanner) {
        int status = Input.receiveRestartGameInput(scanner);
        if (status == RESTART_GAME) {
            return true;
        }
        if (status == EXIT_GAME) {
            return false;
        }
        throw new IllegalArgumentException("숫자 1 또는 2만 입력하셔야 합니다");
    }

    private void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만을 입력해야 합니다.");
        }
    }
}
