package baseball;

import java.util.List;

public class Checker {

    private List<Integer> guesses;
    private List<Integer> answers;
    private Result result;

    public Checker(List<Integer> guesses, List<Integer> answers, Result result) {
        this.guesses = guesses;
        this.answers = answers;
        this.result = result;
        check();
    }

    private void check() {
        for (int num : guesses)
            checkOneNum(num);
    }

    private void checkOneNum(int num) {
        if (answers.contains(num) && answers.indexOf(num) == guesses.indexOf(num))
            result.strike++;
        else if (answers.contains(num))
            result.ball++;
    }
}