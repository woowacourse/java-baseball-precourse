package baseball;

import utils.Answer;
import utils.Input;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        setAnswer();

    }

    public static int[] setAnswer(){
        Answer generateAnswer = new Answer();
        int[] answer = generateAnswer.returnAnswer();
        return answer;
    }



}
