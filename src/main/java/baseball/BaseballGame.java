package baseball;

import utils.NumbersFactory;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private final int NUMBER_OF_DIGITS;
    private final Scanner scanner;

    private boolean isGameEnd = false;

    public BaseballGame(int NUMBER_OF_DIGITS, Scanner scanner){
        this.NUMBER_OF_DIGITS = NUMBER_OF_DIGITS;
        this.scanner = scanner;
    }

    public void play(){
        final Numbers target = getNewTargetNumber();
        do{
            Numbers userGuess = readNumber();
            Score score = calculateScore(target, userGuess);
            printScore(score);
            checkGameOver(score);
        }while(!isGameEnd);

        printAllCorrect();
    }

    private Numbers getNewTargetNumber(){
         return NumbersFactory.createRandomNumbers(NUMBER_OF_DIGITS);
    }

    private Numbers readNumber(){
        return InputView.getGuessNumbers(scanner, NUMBER_OF_DIGITS);
    }

    private Score calculateScore(Numbers target, Numbers guess){
        int strikeCnt = GameRule.countStrike(target, guess);
        int ballCnt = GameRule.countBall(target, guess);

        return new Score(strikeCnt, ballCnt);
    }

    private void printScore(Score score){
        OutputView.printScore(score);
    }

    private void checkGameOver(Score score){
        isGameEnd = GameRule.checkGameEnd(score, NUMBER_OF_DIGITS);
    }

    private void printAllCorrect() {
        OutputView.announceAllCorrect();
    }
}
