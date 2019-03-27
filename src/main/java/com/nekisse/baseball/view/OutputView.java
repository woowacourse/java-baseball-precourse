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
        System.out.println(printStrike(gameTurnResult) + printBall(gameTurnResult));

    }

    private static String printBall(GameTurnResult gameTurnResult) {
        String ballCount = "";
        if (gameTurnResult.checkBall()) {
            ballCount = printBall(gameTurnResult.getBallCount());
        }
        return ballCount;
    }

    private static String printBall(int ballCount) {
        return ballCount + " 볼    ";
    }

    private static String printStrike(GameTurnResult gameTurnResult) {
        String strikeCount = "";
        if (gameTurnResult.checkStrike()) {
            strikeCount = printStrike(gameTurnResult.getStrikeCount());
        }
        return strikeCount;
    }

    private static String printStrike(int strikeCount) {
        return strikeCount + " 스트라이크    ";
    }

    private static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printThreeStrikeGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
