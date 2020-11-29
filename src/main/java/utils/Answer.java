package utils;

import java.util.ArrayList;

public class Answer {

    private ArrayList<Integer> answer = new ArrayList<>();

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer() {
        initializeAnswer();
    }

    private void initializeAnswer() {
        while(answer.size() < 3) {
            int num = RandomUtils.nextInt(1, 9);
            if(answer.indexOf(num) == -1) {
                answer.add(num);
            }
        }
    }
}
