package baseball;

import utils.NumberListGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final int NUMBER_OF_DIGITS;
    private final Scanner scanner;

    private List<Integer> targetNumberList;
    private int strikeCnt;
    private int ballCnt;

    public BaseballGame(int NUMBER_OF_DIGITS, Scanner scanner){
        this.NUMBER_OF_DIGITS = NUMBER_OF_DIGITS;
        this.scanner = scanner;
    }

    public void play(){
        setTargetNumber();
        do{
            String userGuess = readNumber();
            calculateScore(userGuess);
            printScore();
        }while(!checkGameOver());
        printAllCorrect();
    }

    private void setTargetNumber(){
        targetNumberList = NumberListGenerator.makeTargetNumber(NUMBER_OF_DIGITS);
    }

    private String readNumber(){
        return InputView.askGuess(scanner, NUMBER_OF_DIGITS);
    }

    private void calculateScore(String guessed){
        List guessedNumberList = NumberListGenerator.ConvertStringToList(guessed);
        strikeCnt = GameRule.countStrike(targetNumberList, guessedNumberList);
        ballCnt = GameRule.countBall(targetNumberList, guessedNumberList);
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
