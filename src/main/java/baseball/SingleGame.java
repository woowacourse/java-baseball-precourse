package baseball;

import java.util.Scanner;

public class SingleGame {
    private static final String SINGLE_GAME_END = "3스트라이크";

    public static void play(Scanner scanner) {
        int targetNumber = TargetNumberGenerator.makeTargetNumber();
        String strikeAndBallResult = "";
        while (!strikeAndBallResult.equals(SINGLE_GAME_END)){
            int userInputNumber = UserInputNumberGenerator.getUserInput(scanner);
            strikeAndBallResult = BallCount.checkStrikeAndBall(targetNumber,userInputNumber);
            System.out.println(strikeAndBallResult);
        }
    }
}


