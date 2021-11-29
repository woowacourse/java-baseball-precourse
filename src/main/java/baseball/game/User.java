package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> inputNumber() {
        List<Integer> UserNumber = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String readLine = Console.readLine();

        for (String s : readLine.split("")) {
            int parseInt = Integer.parseInt(s);
            UserNumber.add(parseInt);
        }
        return UserNumber;
    }
}

