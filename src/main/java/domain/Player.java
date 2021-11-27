package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Integer> getAnswerInput(){
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> input = new ArrayList<>();
        for (String s : Console.readLine().split("")) {
            Integer parseInt = Integer.parseInt(s);
            input.add(parseInt);
        }

        return input;
    }

    public static boolean getGameRestartInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input = Integer.parseInt(Console.readLine());
        if (input == 1){
            return true;
        }
        return false;
    }
}
