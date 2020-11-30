package baseball;

import utils.CheckDuplicate;
import utils.CheckInputNumber;
import utils.StrikeBallNothingCorrect;

import java.util.Scanner;

public class PlayGame {

    private Scanner scanner;

    public PlayGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void start() {
        int goStop = 1;

        while (goStop == 1) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            goStop = Integer.parseInt(scanner.nextLine());
            goStop = continueGame(String.valueOf(goStop));
        }
    }

    private static void playGame() {
        boolean win = false;
        CheckDuplicate checkDuplicate = new CheckDuplicate();
        String randomNum = checkDuplicate.makeRandomNumber();
        // System.out.println(randomNum);

        CheckInputNumber checkInputNumber = new CheckInputNumber();

        while(!win) {
            String input = checkInputNumber.inputNumber();
            // System.out.println(checkInputNumber.isValid(inputNum));

            StrikeBallNothingCorrect strikeBallNothingCorrect =
                    new StrikeBallNothingCorrect(input, randomNum);
            win = strikeBallNothingCorrect.correctNumbers();
            //System.out.println(test);
        }
    }

    private static int continueGame(String goStop) {
        if(goStop.equals("1")) {
            return 1;
        } else if(goStop.equals("2")) {
            return 2;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}
