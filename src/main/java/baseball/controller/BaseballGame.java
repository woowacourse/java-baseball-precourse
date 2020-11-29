package baseball.controller;

import baseball.model.Numbers;
import baseball.view.InputView;

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
        getNumbersFromUser();
    }

    public void getNumbersFromUser(){
        try{
            this.userNumbers = Numbers.valueOf(InputView.getNumbers());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getNumbersFromUser();
        }
    }

}
