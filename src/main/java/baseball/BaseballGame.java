package baseball;

import utils.InputValidator;
import utils.InvalidInputException;
import utils.NumberListGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final int NUM_DIGITS;
    private final Scanner SCANNER;

    private List<Integer> targetNumberList;
    private List<Integer> guessedNumberList;

    private int strikeCnt, ballCnt;

    public BaseballGame(int NUM_DIGITS, Scanner SCANNER){
        this.NUM_DIGITS = NUM_DIGITS;
        this.SCANNER = SCANNER;
    }

    public void play(){
        setTargetNumber();
        do{
            String userGuess = readNumber();
            calculateScore(userGuess);
            printScore();
        }while(!isGameEnd());
        printAllCorrect();
    }

    private void setTargetNumber(){
        targetNumberList = NumberListGenerator.makeTargetNumList(NUM_DIGITS);
    }

    private String readNumber(){
        try{
            String input = InputView.askNum(SCANNER);
            InputValidator.isValidGuess(input, NUM_DIGITS);
            return input;
        }catch (InvalidInputException IIH){
            OutputView.printMsg(IIH.getMessage());
            return readNumber();
        }
    }

    private void calculateScore(String guessNum){
        guessedNumberList = NumberListGenerator.stringToIntegerList(guessNum);
        strikeCnt = GameRule.countStrike(targetNumberList, guessedNumberList);
        ballCnt = GameRule.countBall(targetNumberList, guessedNumberList);
    }

    private void printScore(){
        OutputView.printScore(strikeCnt, ballCnt);
    }

    private boolean isGameEnd(){
        return GameRule.checkGameEnd(strikeCnt, NUM_DIGITS);
    }

    private void printAllCorrect() {
        OutputView.announceAllCorrect();
    }
}
