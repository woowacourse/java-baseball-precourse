package baseball.model;

import java.util.List;

public class Computer {
    private List<Integer> answer;
    private Record record;

    public Computer(List<Integer> answer, Record record) {
        this.answer = answer;
        this.record = record;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public Record getRecord() {
        return record;
    }
}
