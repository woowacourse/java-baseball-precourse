package baseball;

import baseball.constants.MessageConstants;
import baseball.gamesource.BaseBallGame;
import baseball.util.InputCheck;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input;
        do{
            BaseBallGame newGame = new BaseBallGame();
            newGame.gameStart();
            System.out.println(MessageConstants.RESTART_OR_END_MESSAGE);
            input = Console.readLine();
            InputCheck.checkOptionNumber(input);

        }while(input.equals("1"));
    }
}
