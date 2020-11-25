package domain;

import view.InputView;

import java.util.Scanner;

public class BaseballGame {
    private final Scanner SCANNER;

    public BaseballGame(Scanner SCANNER){
        this.SCANNER = SCANNER;
    }

    public void play(){
        InputView.askGuessNum(SCANNER);
    }
}
