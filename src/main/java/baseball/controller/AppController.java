package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.ParameterSet;
import baseball.model.ResultSet;
import baseball.view.AppView;
import utils.ValidationUtils;

import java.util.Scanner;

public class AppController {
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;

    private static final String START = "0";
    private static final String RESTART = "1";
    private static final String END = "2";

    private AppView appView;
    private ParameterSet parameterSet;
    private BaseBallGame baseBallGame;

    public AppController(Scanner scanner) {
        appView = new AppView(scanner);
        parameterSet = new ParameterSet(NUMBER_OF_DIGITS, MIN_DIGIT, MAX_DIGIT);
        baseBallGame = new BaseBallGame(parameterSet);
    }

    private void showResult(ResultSet resultSet) {
        if (resultSet.numberOfBalls() + resultSet.numberOfStrikes() == 0) {
            appView.outputMessage("낫싱\n");
            return;
        }

        if (resultSet.numberOfBalls() > 0) {
            appView.outputMessage(resultSet.numberOfBalls() + "볼 ");
        }

        if (resultSet.numberOfStrikes() > 0) {
            appView.outputMessage(resultSet.numberOfStrikes() + "스트라이크");
        }

        appView.outputMessage("\n");
    }

    public void run() {
        String userInput = START;
        ResultSet resultSet;
        baseBallGame.generateRandomDigits();

        while (!userInput.equals(END)) {
            appView.outputMessage("숫자를 입력해주세요 : ");
            userInput = appView.inputLine();
            userInput = ValidationUtils.validateInputInProgress(userInput, parameterSet);
            resultSet = baseBallGame.compareDigits(userInput);
            showResult(resultSet);

            if (resultSet.numberOfStrikes() != NUMBER_OF_DIGITS) {
                continue;
            }

            appView.outputMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            appView.outputMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            userInput = appView.inputLine();
            userInput = ValidationUtils.validateInputAfterEnd(userInput, RESTART, END);

            if (userInput.equals(RESTART)) {
                baseBallGame.generateRandomDigits();
            }
        }
    }
}
