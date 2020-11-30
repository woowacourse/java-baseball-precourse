package baseball;

import utils.NumbersFactory;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private final Scanner scanner;

    private boolean isGameEnd = false;

    public BaseballGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void play(){
        final Numbers targetNumbers = getNewTargetNumbers();

        do{
            Numbers userNumbers = readNumber();
            Score score = calculateScore(targetNumbers, userNumbers);
            printScore(score);
            checkGameOver(score);
        }while(!isGameEnd);

        OutputView.printGameOver();
    }

    private Numbers getNewTargetNumbers(){
         return NumbersFactory.createRandomNumbers();
    }

    private Numbers readNumber(){
        return InputView.getNumbers(scanner);
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
        isGameEnd = GameRule.checkGameEnd(score);
    }
}
