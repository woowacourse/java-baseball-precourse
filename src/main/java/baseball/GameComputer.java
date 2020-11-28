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

    static int umpirePitch(String computerChoice, String userChoice) {
        int strike = 0;
        int ball = 0;
        
        for (int i = 0; i < computerChoice.length(); i++) {
            if (computerChoice.charAt(i) == userChoice.charAt(i)) {
                strike += 1;
            }
        }

        for (int i = 0; i < userChoice.length(); i++) {
            if (calculateBall(computerChoice, userChoice.charAt(i))) {
                ball += 1;
            }
        }

        ball -= strike;
        return strike;
    }

    static boolean calculateBall(String computerChoice, int pitch) {
        boolean ball = false;

        for (int i = 0; i<computerChoice.length(); i++) {
            if (computerChoice.charAt(i) == pitch) {
                ball = true;
            }
        }
        return ball;
    }
}
