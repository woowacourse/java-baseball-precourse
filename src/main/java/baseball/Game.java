package baseball;

import java.util.ArrayList;

public class Game {

    public static ArrayList<Integer> randomNumberList = new ArrayList<>();
    public static ArrayList<Integer> userInputNumberList = new ArrayList<>();
    public static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    public static boolean game() {
        randomNumberList = NumberGenerator.getRandomNumberNotRepeat();

        while (true) {
            userInputNumberList = UserInputNumber.userInputNumber();

            NumberCompare numberCompare = new NumberCompare(randomNumberList, userInputNumberList);
            ballStrikeList = NumberCompare.numberCompare();

            if (Hint.hint()) {
                return true;
            }
            return false;
        }
    }

}
