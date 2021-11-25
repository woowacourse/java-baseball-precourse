package baseball;

import baseball.domain.AnswerGenerator;
import baseball.domain.Command;
import baseball.domain.Guess;
import baseball.domain.Referee;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGameController {

    private static final int startInclusive = 1;
    private static final int endInclusive = 9;
    private static final int count= 3;

    public void run() {
        Command inputCommand;

        do {
            runPhase();
            System.out.println(count + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 " + Command.RESTART.symbol() + ", 종료하려면 " + Command.EXIT.symbol() + "를 입력하세요.");
            inputCommand = Command.findCommandBySymbol(Console.readLine());
        } while (inputCommand == Command.RESTART);
    }

    private void runPhase() {
        int strikeCount = 0;
        Referee referee = new Referee();
        List<Integer> answer = new AnswerGenerator(startInclusive, endInclusive,
            count).generate();

        while (strikeCount != count) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> guess = new Guess(Console.readLine(), startInclusive, endInclusive,
                count).getNumbers();

            Result result = referee.judge(answer, guess);
            System.out.println(result);

            strikeCount = result.getStrikeCount();
        }
    }
}