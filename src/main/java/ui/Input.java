package ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {



    public static String playerBallNumberInput() {

        Output.printRequestNumberInput();

        String userBallInput = Console.readLine();

        return userBallInput;
    }

    public static String playerGameStartNumberInput(){

        Output.printRequestRestartInput();
        String userGameStartNumberInput = Console.readLine();

        return userGameStartNumberInput;
    }
}
