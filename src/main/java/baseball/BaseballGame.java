package baseball;

import utils.NumberListGenerator;
import utils.RandomUtils;
import view.InputView;
import view.OutputView;

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
        calculateScore();
    }

    private void makeTargetNumber(){
        for(int i=0; i<NUM_DIGIT; i++){
            targetNumberList.add(getRandWithoutDuplicate());
        }
    }

    private int getRandWithoutDuplicate(){
        int randNum;
        do{
            randNum = RandomUtils.nextInt(MIN_NUM, MAX_NUM);
            System.out.println(randNum);
        }
        while(targetNumberList.contains(randNum));
        return randNum;
    }

    private void calculateScore(){
        int strikeCnt = countStrike();
        int ballCnt = countBall();

        OutputView.printScore(strikeCnt, ballCnt);
    }

    private int countStrike(){
        int strikeCnt =0;
        for(int index= 0; index<NUM_DIGIT; index++){
            if(targetNumberList.get(index) == guessedNumberList.get(index)){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private int countBall(){
        return getNumberOfContain() - countStrike();
    }

    private int getNumberOfContain(){
        int containCnt =0;
        for(int i= 0; i<NUM_DIGIT; i++){
            if(targetNumberList.contains(guessedNumberList.get(i))){
                containCnt++;
            }
        }
        return containCnt;
    }
}
