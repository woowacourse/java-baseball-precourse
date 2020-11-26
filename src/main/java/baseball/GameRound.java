package baseball;

import java.util.Scanner;

public class GameRound {

    private GameData gameData;
    private int[] input = new int[3];

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
        Application application = new Application();
        setGameData(gameData);
        setInput(application.splitNumber(userInput));
    }

    // play one Round
    public void playGameRound(Scanner scanner, AskQuestion askQuestion) {

        gameData.initCounts();

        // count strike cases
        for (int i = 0; i < 3; i++) {
            if (getInput(i) == getGameData().getChosenNumber(i)) {
                getGameData().addStrikeCount();
            }
        }

        // count ball cases
        if (getInput(0) == getGameData().getChosenNumber(1) || getInput(0) == getGameData().getChosenNumber(2)) {
            getGameData().addBallCount();
        }
        if (getInput(1) == getGameData().getChosenNumber(0) || getInput(1) == getGameData().getChosenNumber(2)) {
            getGameData().addBallCount();
        }
        if (getInput(2) == getGameData().getChosenNumber(0) || getInput(2) == getGameData().getChosenNumber(1)) {
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
        if (currentStrikeCount == 3) {
            askQuestion.ask();
            int response = scanner.nextInt();
            askQuestion.askResponse(gameData, response);
        }
    }

}