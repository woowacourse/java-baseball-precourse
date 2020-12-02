package domain;

import ui.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private static final String RESTART_GAME = "1";
    private static final String EXIT_GAME = "2";
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
    }

    private void enterNumber(Scanner scanner) {
        try {
            List<Ball> inputBalls = new ArrayList<>();
            String input = Input.receiveNumberInput(scanner);
            String[] splitedText = input.split("");

            for (int i = 0; i < splitedText.length; i++) {
                validateInteger(splitedText[i]);
                inputBalls.add(new Ball(Integer.parseInt(splitedText[i])));
            }
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
        String status = Input.receiveRestartGameInput(scanner);
        if (status.equals(RESTART_GAME)) {
            return true;
        }
        if (status.equals(EXIT_GAME)) {
            return false;
        }
        throw new IllegalArgumentException("숫자 1 또는 2만 입력하셔야 합니다");
    }

    private void validateInteger(String ball) {
        try {
            Integer.parseInt(ball);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만을 입력해야 합니다.");
        }
    }
}
