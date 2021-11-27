package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import baseball.utils.Validator;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.RESTART_NUM;

public class Player {
    public static List<Integer> getAnswerInput() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> answer = new ArrayList<>();

        String input = Console.readLine();
        Validator.validateAnswerInput(input);

        for (String s : input.split("")) {
            Integer parseInt = Integer.parseInt(s);
            answer.add(parseInt);
        }

        return answer;
    }

    public static boolean getGameRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        Validator.validateRestartInput(input);

        return Integer.parseInt(input) == RESTART_NUM;
    }
}
