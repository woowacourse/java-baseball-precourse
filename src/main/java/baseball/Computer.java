package baseball;

public class Computer {

    private final AnswerGenerator answerGenerator;

    private int[] answer;

    public Computer() {
        this.answerGenerator = new AnswerGenerator();
    }

    public void initialize() {
        this.answer = answerGenerator.generate();
    }
}
