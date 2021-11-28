package baseball;

import baseball.game.BaseballGame;

import static baseball.game.constants.BaseballGameConst.GAMEOVER;
import static baseball.game.constants.BaseballGameConst.RESTART;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현

        while(true) {
            BaseballGame newGame = new BaseballGame();
            if(newGame.start()==GAMEOVER){
                break;
            }
        }
    }
}
