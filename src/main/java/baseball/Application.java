package baseball;

import baseball.constant.Constants;
import baseball.model.Computer;
import baseball.model.Record;
import baseball.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Record record = new Record();
        Computer computer = new Computer(new ArrayList<>(), record);
        User user = new User(new ArrayList<>(), Constants.PLAY);
        BaseballGameController baseballGameController = new BaseballGameController(computer, user);
        startGame(baseballGameController, scanner);
    }

    public static void startGame(BaseballGameController gameController, Scanner scanner) {
        gameController.updateAnswer();
        play(gameController, scanner);
        decideToReplay(gameController, scanner);
    }

    public static void play(BaseballGameController gameController, Scanner scanner) {

        do {
            gameController.resetUserNumber();
            gameController.updateUserNumber(scanner);

            if (gameController.fetchUserNumber().size() != Constants.ANSWER_LENGTH) {
                continue;
            }

            gameController.comparingProcess();
            gameController.updateRecord();
            gameController.printResult();
        } while (!gameController.fetchAnswer().equals(gameController.fetchUserNumber()));
    }

    public static void decideToReplay(BaseballGameController gameController, Scanner scanner) {

        do {
            gameController.updateRetryNumber(scanner);
        } while (gameController.fetchRetryNumber() == Constants.INVALID_RETRY_NUMBER);

        if (gameController.fetchRetryNumber() == Constants.PLAY) {
            startGame(gameController, scanner);
        }

    }
}
