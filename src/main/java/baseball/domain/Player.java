package baseball.domain;

import static baseball.constants.NumberConstant.RESTART_NUM;
import static baseball.constants.OutputMessage.ASK_INPUT_MESSAGE;
import static baseball.constants.OutputMessage.ASK_RESTART_MESSAGE;

import java.util.ArrayList;
import java.util.List;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static List<Integer> getAnswerInput() {
        System.out.print(ASK_INPUT_MESSAGE);

        List<Integer> answer = new ArrayList<>();

        String input = Console.readLine();
        Validator.validateAnswerInput(input);

        for (String s : input.split("")) {
            answer.add(Integer.parseInt(s));
        }

        return answer;
    }

    public static boolean getGameRestartInput() {
        System.out.println(ASK_RESTART_MESSAGE);

        String input = Console.readLine();
        Validator.validateRestartInput(input);

        return Integer.parseInt(input) == RESTART_NUM;
    }
}
