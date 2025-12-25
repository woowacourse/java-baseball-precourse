package baseball;

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
}
