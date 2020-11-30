package baseball;


import utils.Checker;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Number number = new Number();
        int replayNum = 0;
        while(replayNum != 2){
            number.setTarget();
            Round.playOneRound(number, scanner);
            replayNum = Checker.checkReplay(scanner);
        }
        scanner.close();
    }
}
