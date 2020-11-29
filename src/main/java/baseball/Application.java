package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        setupInputSystem(scanner);
        do{
            BaseballGame baseballGame = BaseballGame.createNewGame(Numbers.createRandomNumbers());
            baseballGame.play();
        }while(askRestart());

        OutputView.showTerminationMessage();
    }

    public static void setupInputSystem(Scanner scanner) {
        InputView.setScanner(scanner);
    }

    public static boolean askRestart(){
        try{
            String userInput = InputView.getRestartChoice();
            return valueOfChoice(userInput);
        }catch (IllegalArgumentException e){
            OutputView.showErrorMessage(e.getMessage());
            return askRestart();
        }
    }

    public static boolean valueOfChoice(String choice) {
        final int RESTART = 1;
        final int TERMINATE = 2;
        int choiceValue = Integer.parseInt(choice);

        if (choiceValue == RESTART) {
            return true;
        }
        if (choiceValue == TERMINATE) {
            return false;
        }
        throw new IllegalArgumentException("1 혹은 2만 입력가능합니다.");
    }
}
