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
    public int countBall(ArrayList<Integer> answer, ArrayList<Integer> submission, int strike){
        int count=0;
        for(int i=0;i<answer.size();i++){
            if(answer.get(i)==1&&submission.get(i)==1)
                count++;
        }
        return count-strike;
    }
    void printResult(int strike, int ball) {
        String result = "";
        if (strike == 0 && ball == 0) {
            result += RuleUtils.NOTHING;
        }
        if (strike > 0) {
            result += strike+" "+ RuleUtils.STRIKE;
        }
        if (ball > 0) {
            if (result.length() > 0)
                result += " ";
            result += ball+ RuleUtils.BALL;
        }
        System.out.println(result);
        return;
    }
}