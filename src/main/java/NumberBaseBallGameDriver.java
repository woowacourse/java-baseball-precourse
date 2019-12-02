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
    private static final int BREAK_VALUE = 2;
    private static final int ANSWER_STRIKE = 3;

    public static void main(String[] args) {
        Player aPlayer = new Player();

        while (true) {
            NumberBaseBallGame aNumberBaseBallGame = new NumberBaseBallGame();
            aNumberBaseBallGame.setRandomNumbers(new RandomNumber().create(NumberBaseBallGame.DIGIT,
                    NumberBaseBallGame.MIN_VALUE, NumberBaseBallGame.MAX_VALUE));

            startGame(aNumberBaseBallGame, aPlayer);

            if (aPlayer.inputMenuId() == BREAK_VALUE) {
                break;
            }
        }
    }

    private static void startGame(NumberBaseBallGame numberBaseBallGame, Player player) {
        while (true) {
            Result thisGameResult = numberBaseBallGame.createResult(player.inputNumber());

            System.out.println(thisGameResult.toString());

            if (thisGameResult.getStrike() == ANSWER_STRIKE) {
                break;
            }
        }
    }
}