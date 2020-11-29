package baseball.controller;

import baseball.model.Numbers;

public class BaseballGame {
    private final Numbers answer;
    private Numbers userNumbers;

    private BaseballGame(Numbers answer){
        this.answer = answer;
    }

    public static BaseballGame createNewGame(Numbers answer){
        return new BaseballGame(answer);
    }

    public void play(){
        // 실행 로직
    }

}
