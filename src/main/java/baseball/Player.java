package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static baseball.config.Message.*;

public class Player {
    public static GameNumber scanNumber() {
        System.out.print(INPUT);
        String number = Console.readLine();

        return stringToList(number);
    }

    private static GameNumber stringToList(String number) {
        ArrayList<Integer> playerNumbers = new ArrayList<>();

        for(int i = 0; i < number.length(); i++) {
            playerNumbers.add(Character.getNumericValue(number.charAt(i)));
        }

        return new GameNumber(playerNumbers);
    }
}
