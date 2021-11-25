package baseball;

import baseball.domain.AnswerGenerator;
import baseball.domain.Command;
import baseball.domain.Guess;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.domain.Rule;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGameController {

    private static final int COUNT = Rule.COUNT.value();

    private static final String RESULT_MSG = COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String COMMAND_INPUT_MSG =
        "게임을 새로 시작하려면 " + Command.RESTART.symbol() + ", 종료하려면 " + Command.EXIT.symbol()
            + "를 입력하세요.";
    private static final String NUMBER_INPUT_MSG = "숫자를 입력해주세요 : ";


    public void run() {
        Command inputCommand;

        do {
            runPhase();
            System.out.println(RESULT_MSG);
            System.out.println(COMMAND_INPUT_MSG);
            inputCommand = Command.findCommandBySymbol(Console.readLine());
        } while (inputCommand == Command.RESTART);
    }

    private void runPhase() {
        int strikeCount = 0;
        Referee referee = new Referee();
        List<Integer> answer = new AnswerGenerator().generate();

        while (strikeCount != COUNT) {
            System.out.print(NUMBER_INPUT_MSG);
            List<Integer> guess = new Guess(Console.readLine()).getNumbers();

            Result result = referee.judge(answer, guess);
            System.out.println(result);

            strikeCount = result.getStrikeCount();
        }
    }
}