package baseball;

import java.util.Scanner;

public class Player {

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] numberToArray(int num) {
        String temp = Integer.toString(num);

        int[] userNumber = new int[3];
        for (int i=0; i<3; i++) {
            userNumber[i] = temp.charAt(i) - '0';
        }

        return userNumber;
    }

}