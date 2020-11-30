package baseball;


import java.util.Scanner;

import static baseball.Game.makeGameNumber;

public class Player {

    public static void playGame(Scanner scanner){
        String gameNumber = makeGameNumber();
        System.out.println(gameNumber);

        while (true){
            String inputNumber = scanner.nextLine();

            System.out.println("aaa");
            break;
        }
    }

}

