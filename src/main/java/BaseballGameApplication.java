/*
 * BaseballGameApplication.java
 * java-baseball-precourse
 *
 * Version 0.2
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

import domain.TargetNumberListGenerator;
import domain.UserInputValidator;
import utils.StringHandler;
import view.InputView;

import java.util.ArrayList;

public class BaseballGameApplication {
    public static void main(String[] args) {
            startBaseballGame();
    }

    private static void startBaseballGame() {
        ArrayList<Integer> targetNumberList = setTargetNumberList();
        ArrayList<Integer> userNumberList = setUserNumberList();
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
}
