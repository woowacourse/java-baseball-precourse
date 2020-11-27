package baseball;

import java.util.Scanner;
import constants.SystemMessage;

public class Application {
    private static final String RESTART = "1";
    private static final String END = "2";
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseBall baseBall = new BaseBall(scanner);
        do { 
            baseBall.init();
            baseBall.playGame();
        } while (isUserWantContinue(scanner));
        scanner.close();
    }

    private static boolean isUserWantContinue(Scanner scanner) {
        System.out.println(SystemMessage.GAME_RESTART_OR_END_MESSAGE);
        String sel = scanner.next();
	
        if (sel.equals(RESTART)) {
            return true;
        } else if (sel.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
