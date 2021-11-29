package baseball;

import baseball.constants.MessageConstants;
import baseball.gamesource.BaseBallGame;
import baseball.util.InputCheck;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = null;

        do{
            BaseBallGame newGame = new BaseBallGame();

            //게임 시작
            newGame.gameStart();

            //게임 종료
            System.out.println(MessageConstants.RESTART_OR_END_MESSAGE);
            input = Console.readLine();

            //입력 확인
            InputCheck.checkOptionNumber(input);

        }while(input.equals(MessageConstants.GAME_RESTART_NUM));

    }
}
