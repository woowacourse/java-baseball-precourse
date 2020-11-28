package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BaseBallGame {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART = "1";

    private final Scanner scanner;
    private final Computer computer;

    BaseBallGame(Scanner scanner, Computer computer) {
        this.scanner = scanner;
        this.computer = computer;
    }

    public void play() {
        List<Integer> userNumber;
        Map<String, Integer> strikeAndBall;
        OutputView outputView;
        do {
            userNumber = changeUserInputStringToList(getInput());
            strikeAndBall = computer.compareWithUserNumber(userNumber);
            outputView = new OutputView(strikeAndBall);
            outputView.printHint();
        } while (!outputView.isGameOver());
    }

    public String getInput() {
        System.out.print(INPUT_MESSAGE);
        String input = scanner.nextLine();
        try {
            InputValidator.validateInputIsNumber(input);
            InputValidator.validateInputLengthEqualsDigit(input);
            InputValidator.validateZero(input);
            InputValidator.validateDuplication(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            input = getInput();
        }
        return input;
    }

    public List<Integer> changeUserInputStringToList(String userInput) {
        List<Integer> subdividedUserInput = new ArrayList<>();
        String[] tokensOfUserInput = userInput.split("");
        for (String token : tokensOfUserInput) {
            subdividedUserInput.add(Integer.parseInt(token));
        }
        return subdividedUserInput;
    }

    public String getRestartOrQuitInput() {
        String restartOrQuit = scanner.nextLine();
        try {
            InputValidator.validateRestartOrQuit(restartOrQuit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            restartOrQuit = getRestartOrQuitInput();
        }
        return restartOrQuit;
    }

    public boolean isRestart() {
        if (getRestartOrQuitInput().equals(RESTART)) {
            return true;
        }
        return false;
    }
}
