package baseball;

import utils.NumberListGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {
    private final int NUM_DIGIT;
    private final Scanner SCANNER;

    private ArrayList<Integer> targetNumberList;
    private ArrayList<Integer> guessedNumberList;

    private boolean isGameEnd;
    private int strikeCnt, ballCnt;

    public BaseballGame(int NUM_DIGIT, Scanner SCANNER){
        this.NUM_DIGIT = NUM_DIGIT;
        this.SCANNER = SCANNER;
    }

    public void play(){
        setTargetNumber();
        while(!isGameEnd){
            String userGuess = readNumber();
            calculateScore(userGuess);
            printScore();
            checkGameEnd();
        }
    }

    private void setTargetNumber(){
        targetNumberList = NumberListGenerator.makeTargetNumList(NUM_DIGIT);
    }

    private String readNumber(){
        return InputView.askNum(SCANNER);
    }

    private void calculateScore(String guessNum){
        guessedNumberList = NumberListGenerator.stringToList(guessNum);
        strikeCnt = countStrike();
        ballCnt = countBall();
    }

    private int countStrike(){
        int strikeCnt =0;
        for(int i= 0; i<NUM_DIGIT; i++){
            if(targetNumberList.get(i) == guessedNumberList.get(i)){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private int countBall(){
        int containCnt =0;
        for(int i= 0; i<NUM_DIGIT; i++){
            if(targetNumberList.contains(guessedNumberList.get(i))){
                containCnt++;
            }
        }
        return containCnt - countStrike();
    }

    private void printScore(){
        OutputView.printScore(strikeCnt, ballCnt);
    }

    private void checkGameEnd(){
        if(strikeCnt == NUM_DIGIT){
            OutputView.announceAllCorrect();
            setGameEnd();
        }
    }

    private void setGameEnd(){
        isGameEnd = true;
    }
}
