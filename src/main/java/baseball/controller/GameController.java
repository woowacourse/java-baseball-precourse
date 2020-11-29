/*
 * GameController.java            0.9       2020-11-25
 *
 * Copyright (c) 2020 Yeonwoo Cho
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All rights reserved
 */

package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.NumbersValidator;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.domain.RandomNumbers.NUMBER_LIST_SIZE;

/**
 * 전체 게임을 진행하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class GameController {
    public static final String RESTART_NUMBER = "1";
    public static final String EXIT_NUMBER = "2";

    private List<Integer> randomNumbers = new ArrayList<>();

    public void run(Scanner scanner) {
        this.randomNumbers = generateRandomNumbers();
        playUnitGame(scanner);
    }

    private void playUnitGame(Scanner scanner) {
        final Computer computer = new Computer();
        final List<Integer> validInputNumbers = generateValidInputNumbers(InputView.receiveInputNumbers(scanner));

        computer.calculateResult(validInputNumbers, this.randomNumbers);
        OutputView.printResult(computer.getCountsOfBall(), computer.getCountsOfStrike());
        checkCorrectAnswer(computer.getCountsOfStrike(), scanner);
    }

    private List<Integer> generateValidInputNumbers(String uncheckedInputNumbers) {
        final NumbersValidator numbersValidator = new NumbersValidator();
        return numbersValidator.makeValidNumbers(uncheckedInputNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        final RandomNumbers randomNumbers = new RandomNumbers();
        return randomNumbers.makeRandomNumbers();
    }

    private void checkCorrectAnswer(int countsOfStrike, Scanner scanner) {
        if (countsOfStrike != NUMBER_LIST_SIZE) {
            playUnitGame(scanner);
        } else {
            OutputView.printRestart();
            checkRestartFlag(scanner);
        }
    }

    private void checkRestartFlag(Scanner scanner) {
        final String userInputRestart = InputView.receiveRestartNumber(scanner);
        if (userInputRestart.equals(RESTART_NUMBER)) {
            run(scanner);
        }
        checkInvalidInputInRestart(userInputRestart);
    }

    private void checkInvalidInputInRestart(String userInput) {
        if (!userInput.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }
}
