import utils.RuleUtils;

import java.util.ArrayList;

public class BaseballGame {

    public void run() {
        Player questioner = new PlayerBot();
        Player solver = new PlayerPerson();
        int strike = 0, ball = 0;

        questioner.makeNumbers();
        do {
            solver.makeNumbers();
            strike = countStrike(questioner.numbers, solver.numbers);
            ball = countBall(questioner.numberCounts, solver.numberCounts, strike);
            printResult(strike, ball);
        } while (strike != RuleUtils.DIGITS);
    }

    public int countStrike(ArrayList<Integer> answer, ArrayList<Integer> submission) {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == submission.get(i))
                count++;
        }
        return count;
    }
}