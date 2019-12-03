/**
 * java-baseball-precourse
 * BaseballGame.java
 * Purpose: 숫자 야구 게임의 동작들을 구현함.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */

import utils.RuleUtils;

import java.util.ArrayList;

public class BaseballGame {

    /**
     * 실질적인 게임을 실행하는 Method, 일련의 숫자 야구게임 동작들이 들어간다.
     */
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

    /**
     * @param answer     출제자측이 작성한 내용, 자릿수별로 끊어 ArrayList화 시켰다.
     * @param submission 제출측이 작성한 내용, 자릿수별로 끊어 ArrayList화 시켰다.
     * @return strike 개수
     */
    public int countStrike(ArrayList<Integer> answer, ArrayList<Integer> submission) {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == submission.get(i))
                count++;
        }
        return count;
    }

    /**
     * 출제 조합과 제출 조합이 1로 같은 횟수를 확인해서, strike만큼 빼고 반환한다.
     * 같더라도 위치까지 같은 strike이면 ball에서 빼야하기 때문이다.
     *
     * @param answer     출제자측이 작성한 내용의 조합, ArrayList에 출현 여부가 적혀있다.
     * @param submission 제출측이 작성한 내용의 조합, ArrayList에 출현 여부가 적혀있다.
     * @param strike     위치까지 같은 횟수
     * @return ball 개수, 위치는 다르지만 공통 숫자의 개수
     */
    public int countBall(ArrayList<Integer> answer, ArrayList<Integer> submission, int strike) {
        int count = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == 1 && submission.get(i) == 1)
                count++;
        }
        return count - strike;
    }

    /**
     * 양식에 맞춰 결과를 출력한다.
     *
     * @param strike strike 개수
     * @param ball   ball 개수
     */
    void printResult(int strike, int ball) {
        String result = "";
        if (strike == 0 && ball == 0) {
            result += RuleUtils.NOTHING;
        }
        if (strike > 0) {
            result += strike + " " + RuleUtils.STRIKE;
        }
        if (ball > 0) {
            if (result.length() > 0)
                result += " ";
            result += ball + RuleUtils.BALL;
        }
        System.out.println(result);
        return;
    }
}