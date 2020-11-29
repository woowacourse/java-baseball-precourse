package baseball;

import utils.Converter;
import utils.Printer;
import utils.Validator;

import java.util.Scanner;

public class GameManager {
    private final Scanner scanner;
    private final BaseballManager baseballManager;
    private final Validator validator;
    private final Printer printer;

    private boolean isGameInProgress;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
        baseballManager = new BaseballManager();
        validator = new Validator();
        printer = new Printer();

        isGameInProgress = true;
    }

    public boolean isGameInProgress() {
        return isGameInProgress;
    }

    public void inputUserBaseballs() {
        printer.printInputGuide();

        String inputValue = scanner.nextLine();

        validator.validateInputValue(inputValue);

        int[] convertedValues = Converter.convertString(inputValue);

        baseballManager.setUserBaseballs(convertedValues);
    }

    public void outputUserBaseballResult() {
        int ballNumber = baseballManager.getBallNumber();
        int strikeNumber = baseballManager.getStrikeNumber();

        printer.printResult(ballNumber, strikeNumber);
    }

    public boolean isGameSet() {
        int strikeNumber = baseballManager.getStrikeNumber();

        return strikeNumber == BaseballManager.BASEBALL_NUMBER;
    }

    public void inputGameProgress() {
        printer.printGameProgess();

        String progressInput = scanner.nextLine();

        validator.validateProgressValue(progressInput);

        int progressStatusCode = Integer.parseInt(progressInput);

        setGameStatus(progressStatusCode);
    }

    private void setGameStatus(int statusCode) {
        switch (statusCode) {
            case GameStatusCode.RESTART:
                baseballManager.createRanmdomBaseballs();
                break;
            case GameStatusCode.EXIT:
                isGameInProgress = false;
                break;
        }
    }
}
