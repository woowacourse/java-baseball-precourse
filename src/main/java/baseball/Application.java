package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

//        System.out.println(NumberGenerator.getRandomNumberNotRepeat());
//        System.out.println(UserInputNumber.integerToList("789"));
//        System.out.println(NumberCompare.compareBallCount());
//        System.out.println(NumberCompare.compareStrikeCount());
//        System.out.println();
//        System.out.println(Menu.menu());
        ArrayList<Integer> result = NumberCompare.numberCompare(NumberGenerator.getRandomNumberNotRepeat(), UserInputNumber.integerToList("789"));
        System.out.println(Hint.getHint(result));
        System.out.println(Game.game());

    }
}
