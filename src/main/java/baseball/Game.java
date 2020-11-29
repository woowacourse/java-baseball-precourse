package baseball;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Game {

    public static ArrayList<Integer> randomNumberList = new ArrayList<>();
    public static ArrayList<Integer> userInputNumberList = new ArrayList<>();
    public static ArrayList<Integer> makeUserInputNumberList = new ArrayList<>();
    public static ArrayList<Integer> ballStrikeList = new ArrayList<>();

    public static ArrayList<Integer> game() {
        randomNumberList = NumberGenerator.getRandomNumberNotRepeat();

        while (true) {
            userInputNumberList = integerToList();

            NumberCompare numberCompare = new NumberCompare(randomNumberList, userInputNumberList);
            ballStrikeList = NumberCompare.numberCompare();

            break;
        }
        return ballStrikeList;
    }

    public static ArrayList<Integer> integerToList() {
        int userInputNumber = UserInputNumber.userInputNumber();
        int[] userInputNumberIntList = Stream.of(String.valueOf(userInputNumber).split("")).mapToInt(Integer::parseInt).toArray();

        for (int number : userInputNumberIntList) {
            makeUserInputNumberList.add(number);
        }
        return makeUserInputNumberList;
    }
}
