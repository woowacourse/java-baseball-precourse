package baseball;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        while(game.strike < 3) {
            game.play();
        }
        // System.out.println("종료");
    }
}
