package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    /*
    * 숫자 야구 게임 진행 클래스
    * */

    public static ArrayList<Integer> randomNumberList = new ArrayList<>();
    public static ArrayList<Integer> userNumberList = new ArrayList<>();
    public static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    /*
     * 숫자 야구 게임 진행하고 그에 맞는 힌트를 제공하는 메서드
     * */
    public static void game() {
        randomNumberList = NumberGenerator.getRandomNumberNotRepeat();

        while (true) {
            userNumberList = UserInputNumber.userInputNumber();

            NumberCompare numberCompare = new NumberCompare(randomNumberList, userNumberList);
            ballStrikeList = numberCompare.numberCompare();

            if (Hint.getHint(ballStrikeList)) {
                break;
            }
        }
    }

}