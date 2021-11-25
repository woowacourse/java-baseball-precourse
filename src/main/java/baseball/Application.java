package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자 야구 진행을 총괄하는 메인 클래스
 */
public class Application {
    public static void main(String[] args) {
        Game game;
        do{
            game=new Game();
            game.playBaseball();
        }while(game.askRestart());
    }
}
