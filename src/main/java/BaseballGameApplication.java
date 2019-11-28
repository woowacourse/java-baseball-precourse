/*
 * BaseballGameApplication.java
 * java-baseball-precourse
 *
 * Version 0.4
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

import domain.BaseballGame;
import domain.TargetNumberListGenerator;
import domain.UserInputValidator;
import utils.StringHandler;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class BaseballGameApplication {
    public static void main(String[] args) {
            ArrayList<Integer> targetNumberList = setTargetNumberList();
            startBaseballGame(targetNumberList);
    }

    private static void startBaseballGame(ArrayList<Integer> targetNumberList) {
        ArrayList<Integer> userNumberList = setUserNumberList();
        BaseballGame baseballGame = new BaseballGame(userNumberList, targetNumberList);
        if(!baseballGame.getIsWinning()) {
            printResult(baseballGame);
            startBaseballGame(targetNumberList);
        }
        OutputView.printWinningMessage();
    }

    private static ArrayList<Integer> setTargetNumberList() {
        TargetNumberListGenerator targetNumberListGenerator = new TargetNumberListGenerator();
        return targetNumberListGenerator.getTargetNumberList();
    }

    private static ArrayList<Integer> setUserNumberList() {
        String userNumberString = InputView.getUserString();
        UserInputValidator userInputValidator = new UserInputValidator(userNumberString);
        if(!userInputValidator.getIsValid()) {
            throw new IllegalArgumentException("입력 오류");
        }
        return StringHandler.addToList(userNumberString);
    }

    private static void printResult(BaseballGame baseballGame) {
        if(baseballGame.getIsNothing()) {
            OutputView.printNothingMessage();
            return;
        }
        OutputView.printStrikeAndBall(baseballGame.getStrikeNumber(), baseballGame.getBallNumber());
    }
}
