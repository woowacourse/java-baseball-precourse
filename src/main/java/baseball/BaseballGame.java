package baseball;

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

    public BaseballGame(Scanner SCANNER){
        this.SCANNER = SCANNER;
    }

    public void play(){
        InputView.askGuessNum(SCANNER);
        makeTargetNumber();
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
