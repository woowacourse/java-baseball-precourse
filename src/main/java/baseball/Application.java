package baseball;

import static baseball.Constants.MESSAGE_GAME_FINISHED;
import static baseball.Constants.MESSAGE_GAME_REPLAY;
import static baseball.UtilityFunctions.parseGameExitString;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        ConsoleBaseballProgram program = new ConsoleBaseballProgram(scanner);
        program.run();
    }
}
