package baseball;

import utils.InputValidator;
import utils.NumberListGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final int NUMBER_DIGITS;
    private final Scanner SCANNER;

    private List<Integer> targetNumberList;
    private List<Integer> guessedNumberList;

    private int strikeCnt;
    private int ballCnt;

    public BaseballGame(int NUMBER_DIGITS, Scanner SCANNER){
        this.NUMBER_DIGITS = NUMBER_DIGITS;
        this.SCANNER = SCANNER;
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
        targetNumberList = NumberListGenerator.makeTargetNumList(NUMBER_DIGITS);
    }

    private String readNumber(){
        try{
            String input = InputView.askNum(SCANNER);
            InputValidator.isValidGuess(input, NUMBER_DIGITS);
            return input;
        }catch (IllegalArgumentException IAE){
            OutputView.printMsg(IAE.getMessage());
            IAE.printStackTrace();
            return readNumber();
        }
    }

    private void calculateScore(String guessed){
        guessedNumberList = NumberListGenerator.ConvertStringToList(guessed);
        strikeCnt = GameRule.countStrike(targetNumberList, guessedNumberList);
        ballCnt = GameRule.countBall(targetNumberList, guessedNumberList);
    }

    private void printScore(){
        OutputView.printScore(strikeCnt, ballCnt);
    }

    private boolean checkGameOver(){
        return GameRule.checkGameEnd(strikeCnt, NUMBER_DIGITS);
    }

    private void printAllCorrect() {
        OutputView.announceAllCorrect();
    }
}
