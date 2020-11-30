package baseball;

import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.domain.ScoreBoard;
import baseball.domain.Target;
import baseball.validator.GameNumberFormatValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private Scanner scanner;

    public BaseballGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void run(){
        boolean isFinished = false;
        while(!isFinished){
            start();
            InputView.printResult(false);
            String input = scanner.nextLine();
            if(!GameNumberFormatValidator.validate(input)){
                throw new IllegalArgumentException();
            }
            if(input.equals("2")){
                isFinished = false;
            }
        }
    }

    public void start(){
        Target target = new Target();
        Player player = new Player(scanner);
        Referee referee = new Referee(target, player);
        while(true){
            InputView.printResult(true);
            player.getInputValue();
            ScoreBoard scoreBoard = referee.judge();
            OutputView.printResult(scoreBoard);
            if(scoreBoard.getStrike() == scoreBoard.getNumbersToGuess()){
                break;
            }
        }
    }
}
