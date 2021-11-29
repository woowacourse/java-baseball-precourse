package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> inputNumber() {
        List<Integer> UserNumber = new ArrayList<>();

        System.out.print(Constant.INPUT_MESSAGE);
        String readLine = Console.readLine();

        Validation.isValidInput(readLine);

        for (String s : readLine.split("")) {
            int parseInt = Integer.parseInt(s);
            UserNumber.add(parseInt);
        }

        return UserNumber;
    }

    public static boolean isGameRestart() {
        System.out.println(Constant.INPUT_RESTART_MESSAGE);
        String readLine = Console.readLine();

        Validation.isValidRestartInput(readLine);

        if (Integer.parseInt(readLine) == Constant.GAME_RESTART) {
            return true;
        }

        return false;
    }
}

