package com.nekisse.baseball;

public class OutputView {


    public static void printTurnResult(GameTurnResult gameTurnResult) {
        System.out.println(gameTurnResult.getStrikeCount()+"스트라이크 " + gameTurnResult.getBallCount() + "볼");
    }

    public static void printThreeStrikeGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
