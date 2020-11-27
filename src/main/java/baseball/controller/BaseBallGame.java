package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import utils.InputUtils;

import java.util.Scanner;

public class BaseBallGame {
    public static void start(Scanner scanner) {
        Computer.makeBalls();
        User.makeBalls(InputUtils.checkUserInput(scanner.nextLine()));
    }
}
