package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(NumberGenerator.getRandomNumberNotRepeat());
        System.out.println(UserInputNumber.integerToList("789"));
//        System.out.println(Game.game());
        System.out.println(Hint.getHint());
//        System.out.println(NumberCompare.numberCompare());
//        System.out.println(Menu.menu());

    }
}
