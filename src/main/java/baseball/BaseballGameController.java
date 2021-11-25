package baseball;

import baseball.domain.AnswerGenerator;
import baseball.domain.Guess;
import baseball.domain.Referee;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGameController {

    private static final int startInclusive = 1;
    private static final int endInclusive = 9;
    private static final int count= 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public void run() {
        String retry;

        do {
            runPhase();
            System.out.println(count + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + EXIT + "를 입력하세요.");
            retry = Console.readLine();
        } while (retry.equals(RESTART));
    }

    private void runPhase() {
        int strikeCount = 0;
        Referee referee = new Referee();
        List<Integer> answer = new AnswerGenerator(startInclusive, endInclusive,
            count).generate();

        System.out.println(answer);

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