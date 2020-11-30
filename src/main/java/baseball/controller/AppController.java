package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.model.ParameterSet;
import baseball.view.AppView;

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

    public void run() {
    }
}
