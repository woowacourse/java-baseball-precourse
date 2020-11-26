package baseball;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.domain.game.Game;
import baseball.domain.game.GameStatus;
import baseball.domain.pitching.Pitchings;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        ConsoleInput consoleInput = ConsoleInput.of(scanner);
        ConsoleOutput consoleOutput = ConsoleOutput.basic();

        start(consoleInput, consoleOutput);
    }

    private static void start(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        GameStatus gameStatus = GameStatus.RUN;
        while (gameStatus == GameStatus.RUN) {
            gameStart(consoleInput, consoleOutput);
            consoleOutput.printNextGameStatusMessage();
            gameStatus = GameStatus.get(consoleInput.readNextGameStatus());
        }
    }

    private static void gameStart(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        final Game game = Game.generate();
        while (!game.isComplete()) {
            consoleOutput.printInputPitchingsMessage();
            String PitchingsStr = consoleInput.readPitchings();

            try {
                Pitchings target = Pitchings.of(PitchingsStr);
                game.start(target);
            } catch (RuntimeException e) {
                consoleOutput.println(e.getMessage());
                continue;
            }

            consoleOutput.println(game.getJudgeResult());
        }

        consoleOutput.printWinningMessage();
    }
}
