package baseball;

import baseball.vo.JudgeResult;
import baseball.vo.SecretAnswer;

public class Computer {

    private final AnswerGenerator answerGenerator;

    private SecretAnswer answer;

    public Computer() {
        this.answerGenerator = new AnswerGenerator();
    }

    public void initialize() {
        int[] numbers = answerGenerator.generate();
        this.answer = new SecretAnswer(numbers);
    }

    public JudgeResult judge(int[] userInput) {
        return answer.compareWith(userInput);
    }
}
