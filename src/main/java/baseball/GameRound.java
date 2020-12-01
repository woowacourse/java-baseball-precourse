package baseball;

import java.util.Scanner;

public class GameRound {

    private GameData gameData;
    private int[] input = new int[Application.MAX_NUM_SIZE];

    public GameData getGameData() {
        return gameData;
    }

    public int getInput(int index) {
        return input[index];
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public void setInput(int[] input) {
        this.input = input;
    }

    public GameRound(GameData gameData, int userInput) {
        Application application = new Application(); // to use splitNumber()
        setGameData(gameData);
        setInput(application.splitNumber(userInput));
    }

    // play one Round
    public void playGameRound(Scanner scanner, AskQuestion askQuestion) {

        gameData.initCounts();

        // count strike cases
        for (int i = 0; i < Application.MAX_NUM_SIZE; i++) {
            if (getInput(i) == getGameData().getChosenNumber(i)) {
                getGameData().addStrikeCount();
            }
        }

        // count ball cases
        if (getInput(Application.NumberOrder.FIRST.ordinal()) == getGameData().getChosenNumber(Application.NumberOrder.SECOND.ordinal())
            || getInput(Application.NumberOrder.FIRST.ordinal()) == getGameData().getChosenNumber(Application.NumberOrder.THIRD.ordinal())) {
            getGameData().addBallCount();
        }
        if (getInput(Application.NumberOrder.SECOND.ordinal()) == getGameData().getChosenNumber(Application.NumberOrder.FIRST.ordinal())
            || getInput(Application.NumberOrder.SECOND.ordinal()) == getGameData().getChosenNumber(Application.NumberOrder.THIRD.ordinal())) {
            getGameData().addBallCount();
        }
        if (getInput(Application.NumberOrder.THIRD.ordinal()) == getGameData().getChosenNumber(Application.NumberOrder.FIRST.ordinal())
            || getInput(Application.NumberOrder.THIRD.ordinal()) == getGameData().getChosenNumber(Application.NumberOrder.SECOND.ordinal())) {
            getGameData().addBallCount();
        }

        // make a decision on current round
        int currentBallCount = getGameData().getBallCount();
        int currentStrikeCount = getGameData().getStrikeCount();
        if (currentBallCount > 0) {
            System.out.print(currentBallCount + "볼 ");
        }
        if (currentStrikeCount > 0) {
            System.out.print(currentStrikeCount + "스트라이크");
        }
        if (currentBallCount == 0 && currentStrikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        // victory case
        if (currentStrikeCount == Application.MAX_NUM_SIZE) {
            askQuestion.ask();
            while (!askQuestion.getIsVaildInput()) {
                // scanner.next() don't require buffer flush in this situation
                String response = scanner.next();
                askQuestion.askResponse(gameData, response);
            }
            // assume that the input will not be valid
            askQuestion.setIsValidInput(false);
        }
    }

}