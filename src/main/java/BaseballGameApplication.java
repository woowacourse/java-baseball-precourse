/*
 * BaseballGameApplication.java
 * java-baseball-precourse
 *
 * Version 0.1
 *
 * Created by 김경준 on 28/11/2019.
 *
 * Copyright © 2019 kouz95. All rights reserved.
 */

import domain.TargetNumberListGenerator;

import java.util.ArrayList;

public class BaseballGameApplication {
    public static void main(String[] args) {
            startBaseballGame();
    }

    private static void startBaseballGame() {
        ArrayList<Integer> targetNumberList = setTargetNumberList();
    }

    private static ArrayList<Integer> setTargetNumberList() {
        TargetNumberListGenerator targetNumberListGenerator = new TargetNumberListGenerator();
        return targetNumberListGenerator.getTargetNumberList();
    }
}
