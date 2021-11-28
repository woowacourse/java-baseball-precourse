package baseball;

import baseball.domain.GameBalls;
import baseball.domain.GameGuidePrinter;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        GameGuidePrinter.inputUserNumber();
        String userNumber = Console.readLine();

        GameBalls balls = new GameBalls(userNumber);
    }
}
