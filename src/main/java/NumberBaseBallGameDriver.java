/*
 * @(#)NumberBaseBallGameDriver.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

public class NumberBaseBallGameDriver {
    private static final int CONTINUE_VALUE = 1;

    public static void main(String[] args) {
        Printer aPrinter = new Printer();
        Input aInput = new Input();

        while (true) {
            NumberBaseBallGame aNumberBaseBallGame = new NumberBaseBallGame();

            while (!aNumberBaseBallGame.isAnswer()) {
                aNumberBaseBallGame.calculateResult(aInput.inputNumber());
                aPrinter.printHint(aNumberBaseBallGame);
            }

            aPrinter.printAnswerText();

            if (!isContinue(aInput.inputMenuId())) {
                break;
            }
        }
    }

    public static boolean isContinue(int menuId) {
        return menuId == CONTINUE_VALUE;
    }
}