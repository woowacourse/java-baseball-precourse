package baseball;


import java.util.Scanner;

import static baseball.Game.makeGameNumber;

public class Player {

    public static void playGame(Scanner scanner){
        String gameNumber = makeGameNumber();
        System.out.println(gameNumber);

        while (true){
            String inputNumber = scanner.nextLine();

            // 숫자 확인
            boolean isNumeric = inputNumber.chars().allMatch(Character::isDigit);

            // 길이 확인
            boolean compareLength = inputNumber.length() == gameNumber.length();
            if (!isNumeric || !compareLength) {
                System.out.printf("%b %b \n",isNumeric,compareLength);
                continue;
            }

            System.out.println("aaa");
            break;
        }
    }

}

