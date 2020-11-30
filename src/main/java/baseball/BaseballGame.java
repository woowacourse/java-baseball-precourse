package baseball;

import utils.NumbersFactory;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private final int NUMBER_OF_DIGITS;
    private final Scanner scanner;

    private Numbers target;
    private int strikeCnt;
    private int ballCnt;

    public BaseballGame(int NUMBER_OF_DIGITS, Scanner scanner){
        this.NUMBER_OF_DIGITS = NUMBER_OF_DIGITS;
        this.scanner = scanner;
    }

    public void play(){
        setTargetNumber();
        do{
            Numbers userGuess = readNumber();
            calculateScore(userGuess);
            printScore();
        }while(!checkGameOver());
        printAllCorrect();
    }

    private void setTargetNumber(){
         target = NumbersFactory.getRandomNumbers(NUMBER_OF_DIGITS);
    }

    private Numbers readNumber(){
        return InputView.askGuess(scanner, NUMBER_OF_DIGITS);
    }

    private void calculateScore(Numbers guess){
        strikeCnt = GameRule.countStrike(target, guess);
        ballCnt = GameRule.countBall(target, guess);
    }

    private void printScore(){
        OutputView.printScore(strikeCnt, ballCnt);
    }

    private boolean checkGameOver(){
        return GameRule.checkGameEnd(strikeCnt, NUMBER_OF_DIGITS);
    }

    private void printAllCorrect() {
        OutputView.announceAllCorrect();
    }
}
