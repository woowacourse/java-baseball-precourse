package baseball.model;

import java.util.List;

public class Computer {
    private List<Integer> answer;

    public Computer(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
