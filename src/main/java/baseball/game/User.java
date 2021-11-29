package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> inputNumber() {
        List<Integer> UserNumber = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String readLine = Console.readLine();

        Validation.isValidInput(readLine);

        for (String s : readLine.split("")) {
            int parseInt = Integer.parseInt(s);
            UserNumber.add(parseInt);
        }
        return UserNumber;
    }

    public static boolean isGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String readLine = Console.readLine();

        if (Integer.parseInt(readLine) == 1) {
            return true;
        }
        return false;
    }
}

