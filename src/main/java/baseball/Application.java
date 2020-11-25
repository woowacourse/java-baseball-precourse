package baseball;

import view.InputView;

import java.util.Scanner;

public class Application {
    private static boolean isAppEnd = false;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseballGame baseballGame;

        while(!isAppEnd){
            baseballGame = new BaseballGame(scanner);
            baseballGame.play();

            checkPlayAgain(scanner);
        }
    }

    private static void checkPlayAgain(Scanner SCANNER){
        String inputLine = InputView.askPlayAgain(SCANNER);
        if(inputLine.equals("2")){
            isAppEnd = true;
        }
    }
}
