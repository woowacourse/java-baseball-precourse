package baseball.controller;

import java.util.Scanner;

public class BaseballGameController {
    private final Viewer viewer;

    public BaseballGameController(final Scanner scanner) {
        this.viewer = new Viewer(scanner);
    }
}
