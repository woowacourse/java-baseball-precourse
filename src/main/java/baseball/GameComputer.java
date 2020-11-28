package baseball;

import java.util.Scanner;
import java.util.Arrays;
import utils.RandomUtils;

public class GameComputer {
    final Scanner scanner = new Scanner(System.in);
    static String computerChoice;
    int strike;
    int ball;

    static String chooseComputerChoice(){
        int[] answer = new int[3];

        answer[0] = RandomUtils.nextInt(1,9);
        do {
            answer[1] = RandomUtils.nextInt(1,9);
        } while (answer[0] == answer[1]);
        do {
            answer[2] = RandomUtils.nextInt(1,9);
        } while (answer[0] == answer[2] || answer[1] == answer[2]);
        computerChoice = Arrays.toString(answer).replaceAll("[^0-9]","");
        return computerChoice;
    }

    int umpireStrike(String computerChoice) {
        return strike;
    }

    int umpireball(String computerChoice) {
        return ball;
    }
}
