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
