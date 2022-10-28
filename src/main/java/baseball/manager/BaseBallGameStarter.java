package baseball.manager;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.domain.UserInputChecker;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseBallGameStarter {
    private static final User user = new User();
    private static final Computer computer = new Computer();

    public static void run() {

        do {
            computer.setComputerNumber();
            startUntilThreeStrike();
        } while (isRestart());

    }

    private static void startUntilThreeStrike() {
        setUserNumber();
        CheckTotalGameStatus checkTotalGameStatus = new CheckTotalGameStatus(user.getUserNumber(), computer.getComputerNumber());
        printResult(checkTotalGameStatus);

        if (!checkTotalGameStatus.getIsWinning()) {
            startUntilThreeStrike();
            return;
        }

        OutputView.printWinningMessage();
    }

    private static void printResult(CheckTotalGameStatus checkTotalGameStatus) {

        if (checkTotalGameStatus.getIsNothing()) {
            OutputView.printNothing();
            return;
        }

        OutputView.printStrikeAndBall(checkTotalGameStatus.getStrikeNumber(), checkTotalGameStatus.getBallNumber());
    }

    private static boolean isRestart() {
        final String NEW_GAME = "1";
        final String EXIT_GAME = "2";

        String userInput = InputView.getNewGameOrExitNumber();

        if (!userInput.equals(NEW_GAME) && !userInput.equals(EXIT_GAME)) {
            throw new IllegalArgumentException("입력 오류");
        }

        return userInput.equals(NEW_GAME);
    }

    private static void setUserNumber() {
        String userInput = InputView.getUserString();
        UserInputChecker userInputChecker = new UserInputChecker(userInput);

        if (!userInputChecker.getIsValid()) {
            throw new IllegalArgumentException("입력 오류");
        }

        user.setUserNumber(new ArrayList<>(Arrays.asList(userInput.split(""))
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList())
        ));
    }
}
