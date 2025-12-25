package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecretAnswer {

    private final List<Integer> answer;

    public SecretAnswer(int[] answer) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(answer).forEach(list::add);

        this.answer = list;
    }

    public JudgeResult compareWith(int[] userInput) {
        boolean[] selected = new boolean[userInput.length];

        int strikeCount = countStrike(userInput, selected);
        int ballCount = countBall(userInput, selected);

        return JudgeResult.of(strikeCount, ballCount);
    }

    private int countStrike(int[] userInput, boolean[] selected) {
        int count = 0;

        for(int i = 0; i < userInput.length; i++) {
            int answerDigit = answer.get(i);
            int inputDigit = userInput[i];

            if(answerDigit == inputDigit) {
                count++;
                selected[i] = true;
            }
        }

        return count;
    }

    private int countBall(int[] userInput, boolean[] selected) {
        int count = 0;

        for(int i = 0; i < userInput.length; i++) {
            int inputDigit = userInput[i];
            if(!selected[i] && answer.contains(inputDigit)) {
                count++;
            }
        }

        return count;
    }
}
