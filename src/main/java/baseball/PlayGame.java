package baseball;

import java.util.Scanner;

public class PlayGame {

    private final CheckInputNumber checkInputNumber;
    private final CheckDuplicate checkDuplicate;
    private final Scanner scanner;
    private boolean goStop;

    public PlayGame(Scanner scanner){
        this.scanner= scanner;
        this.checkInputNumber = new CheckInputNumber(scanner);
        this.checkDuplicate = new CheckDuplicate();
    }

    public void start() {
        goStop = true;
        while (goStop) {
            play();
        }
    }

    private void play() {
        boolean win = false;
        String random = checkDuplicate.makeRandomNumber();
        System.out.println(random);

        while(!win) {
            String input = checkInputNumber.inputNumber();
            CheckResult checkResult = new CheckResult(input, random);
            win = checkResult.correctNumbers();
        }
        continueGame(scanner.nextLine());
    }

    private void continueGame(String input) {
        if(checkInputNumber.isValidRestart(input)){
            goStop = false;
        }
    }
}
