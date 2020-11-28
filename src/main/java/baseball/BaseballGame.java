package baseball;

import utils.InputValidator;
import utils.NumberListGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final int NUMBER_OF_DIGITS;
    private final Scanner SCANNER;

    private List<Integer> targetNumberList;
    private List<Integer> guessedNumberList;

    private int strikeCnt;
    private int ballCnt;

    public BaseballGame(int NUMBER_OF_DIGITS, Scanner scanner){
        this.NUMBER_OF_DIGITS = NUMBER_OF_DIGITS;
        this.SCANNER = scanner;
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
        try{
            String input = InputView.askGuess(SCANNER);
            InputValidator.isValidGuess(input, NUMBER_OF_DIGITS);
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
        return GameRule.checkGameEnd(strikeCnt, NUMBER_OF_DIGITS);
    }

    private void printAllCorrect() {
        OutputView.announceAllCorrect();
    }
}
