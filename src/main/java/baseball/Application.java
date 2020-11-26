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

        GameStatus gameStatus = GameStatus.RUN;
        while (gameStatus == GameStatus.RUN) {

            final Game game = Game.generate();
            while (!game.isComplete()) {
                consoleOutput.printInputPitchingsMessage();

                Pitchings target = Pitchings.of(consoleInput.readPitchings());
                game.start(target);

                consoleOutput.println(game.getJudgeResult());
            }

            consoleOutput.printWinningMessage();
            consoleOutput.printNextGameStatusMessage();

            gameStatus = GameStatus.get(consoleInput.readNextGameStatus());
        }
    }
}
