/*
 * @(#)Printer.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

public class Printer {

    public static void printInputGuide() {
        System.out.print("숫자를 입력해주세요.: ");
    }

    public static void printAnswerText() {
        System.out.println(NumberBaseBallGame.DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public static void printHint(NumberBaseBallGame aNumberBaseBallGame) {
        GameResult gameResult = aNumberBaseBallGame.getGameResult();

        StringBuilder builder = new StringBuilder();
        if (gameResult.getStrike() > 0) {
            builder.append(gameResult.getStrike()+" 스트라이크 ");
        }
        if(gameResult.getBall() > 0) {
            builder.append(gameResult.getBall()+"볼");
        }

        System.out.println(builder.toString());
    }

    public static void printMenu() {
        System.out.println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
