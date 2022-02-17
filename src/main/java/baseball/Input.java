package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String userNumber() {
        Output.requestUserNumber();
        return Console.readLine();
    }

    public static String restartGame() {

        return Console.readLine();
    }
}
