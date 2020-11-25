package baseball;

import utils.NumberListGenerator;
import utils.RandomUtils;
import view.InputView;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;
    private static final int NUM_DIGIT = 3;

    private final Scanner SCANNER;
    private ArrayList<Integer> targetNumberList = new ArrayList<>();
    private ArrayList<Integer> guessedNumberList = new ArrayList<>();

    public BaseballGame(Scanner SCANNER){
        this.SCANNER = SCANNER;
    }

    public void play(){
        makeTargetNumber();
        String guessedNum = InputView.askGuessNum(SCANNER);
        guessedNumberList = NumberListGenerator.convertNumberList(guessedNum);
    }

    private void makeTargetNumber(){
        for(int i=0; i<NUM_DIGIT; i++){
            targetNumberList.add(getRandWithoutContain());
        }
    }

    private int getRandWithoutContain(){
        int randNum;
        do{
            randNum = RandomUtils.nextInt(MIN_NUM, MAX_NUM);
            System.out.println(randNum);
        }
        while(targetNumberList.contains(randNum));
        return randNum;
    }
}
