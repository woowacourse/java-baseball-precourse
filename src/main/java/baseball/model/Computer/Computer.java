package baseball.model.Computer;

public class Computer {
    private AnswerNumber answerNumber;

    public Computer() {
        answerNumber = new AnswerNumber();
    }

    public String getAnswerNumber() {
        return answerNumber.getAnswerNumber();
    }
}
