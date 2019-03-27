package com.nekisse.baseball.view;

import com.nekisse.baseball.GameTurnResult;

public class OutputView {



    public static void printException(Exception e) {
        System.out.println(e.getMessage());

    }

    public static void printTurnResult(GameTurnResult gameTurnResult) {
        if (gameTurnResult.isNothing()) {
            printNothing();
            return;
        }

        System.out.println(gameTurnResult.getStrikeCount()+"스트라이크 " + gameTurnResult.getBallCount() + "볼");

    }

    private static void printNothing() {
        System.out.println("낫싱");

    }

    public static void printThreeStrikeGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
