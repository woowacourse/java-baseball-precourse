package baseball;

import utils.Answer;
import utils.Input;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        setAnswer();
        input();

    }

    public static int[] setAnswer(){
        Answer generateAnswer = new Answer();
        int[] answer = generateAnswer.returnAnswer();
        return answer;
    }


    public static int[] input(){
        Input generateInput = new Input();
        int[] input = generateInput.getInput();
        return input;
    }



}
