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
    private static final int COMPARE_VALUE = 0;

    public void printInputNumber() {
        System.out.print("숫자를 입력해주세요.: ");
    }

    public void printAnswerText() {
        println(NumberBaseBallGame.DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public void printHint(NumberBaseBallGame aNumberBaseBallGame) {
        if (aNumberBaseBallGame.getStrike() == NumberBaseBallGame.DIGIT) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        if (aNumberBaseBallGame.getStrike() > COMPARE_VALUE) {
            builder.append(aNumberBaseBallGame.getStrike() + " 스트라이크 ");
        }
        if (aNumberBaseBallGame.getBall() > COMPARE_VALUE) {
            builder.append(aNumberBaseBallGame.getBall() + "볼");
        }
        if (builder.length() == COMPARE_VALUE) {
            builder.append("낫싱") ;
        }

        println(builder.toString());
    }

    public void printMenu() {
        println("게임을 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printException(IllegalArgumentException e) {
        println(e.getMessage());
    }

    private void println(String text) {
        System.out.println(text);
    }
}
