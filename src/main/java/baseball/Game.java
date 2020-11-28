package baseball;

import java.util.ArrayList;

public class Game {

    public static ArrayList<Integer> randomNumberList = new ArrayList<>();
    public static ArrayList<Integer> userInputNumberList = new ArrayList<>();
    public static ArrayList<Integer> userInputNumberMakeList = new ArrayList<>();
    public static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    public static void game() {
        randomNumberList = NumberGenerator.getRandomNumberNotRepeat();

//        while (true) {
//            userInputNumberList = integerToList();
//
//            NumberCompare numberCompare = new NumberCompare(randomNumberList, userInputNumberList);
//            ballStrikeList = numberCompare.
//
//        }
    }

    public static ArrayList<Integer> integerToList() {
        String userInputNumber = UserInputNumber.userInputNumber();
        int numberInteger;

        for (char number : userInputNumber) {
            numberInteger = Integer.parseInt(String.valueOf(number));
            userInputNumberMakeList.add(numberInteger);
        }
        return userInputNumberMakeList;
    }
}
