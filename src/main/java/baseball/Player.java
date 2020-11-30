package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Player {

    public static int getPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> numberToArray(int num) {
        String temp = Integer.toString(num);

        List<Integer> userNumber = new ArrayList<>();
        for (int i=0; i<3; i++) {
            userNumber.add(temp.charAt(i) - '0');
        }

        return userNumber;
    }

}