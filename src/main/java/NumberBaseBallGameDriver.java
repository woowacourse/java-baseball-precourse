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

        while (true) {
            NumberBaseBallGame aNumberBaseBallGame = new NumberBaseBallGame();

            while (!aNumberBaseBallGame.isAnswer()) {
                aNumberBaseBallGame.setPlayerNumber(PlayerInput.inputNumber());

                aNumberBaseBallGame.calculateResult();
                Printer.printHint(aNumberBaseBallGame);
            }

            Printer.printAnswerText();
            int menuId = PlayerInput.inputMenuId();

            if (!isContinue(menuId)) {
                break;
            }
        }
    }

    public static boolean isContinue(int menuId) {
        return menuId == CONTINUE_VALUE;
    }
}