package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class BaseballGame {
    private static int[] answer = new RandomAnswer().generate();

    public void start() {
        System.out.println(Constants.GAME_START_MSG);

        while (true) {
            playGame();

            System.out.println(Constants.GAME_RESTART_OR_STOP_MSG);

            if (!restartOrStop()) {
                break;
            }
        }
    }

    private void playGame() {
        while (true) {
            System.out.print(Constants.INPUT_NUMBER_MSG);
            String userInput = UserInputValidator.check(Console.readLine());
            int balls = countBalls(userInput);
            int strikes = countStrikes(userInput);
            System.out.println(resultMessage(balls, strikes));

            if (stopGame(strikes)) {
                System.out.println(Constants.GAME_END_MSG);
                break;
            }
        }
    }

    private int countBalls(String userInput) {
        int balls = 0;

        for (int i = 0; i<Constants.ANSWER_LENGTH; i++) {
            int target = Character.getNumericValue(userInput.charAt(i));

            if (answer[i] != target && Arrays.stream(answer).anyMatch(e -> e == target)) {
                balls++;
            }
        }
        return balls;
    }

    private int countStrikes(String userInput) {
        int strikes = 0;

        for (int i = 0; i<Constants.ANSWER_LENGTH; i++) {
            int target = Character.getNumericValue(userInput.charAt(i));

            if (answer[i] == target) {
                strikes++;
            }
        }
        return strikes;
    }

    private boolean stopGame(int strikes) {
        return strikes == Constants.ANSWER_LENGTH;
    }
    
    private String resultMessage(int balls, int strikes) {
        String message = "";

        if (balls != 0) {
           message += Integer.toString(balls) + Constants.BALL;
        }

        if (!message.equals("")) {
            message += " ";
        }

        if (strikes != 0) {
            message += Integer.toString(strikes) + Constants.STRIKE;
        }

        if (balls == 0 && strikes == 0) {
            message = Constants.NOTHING;
        }

        return message;
    }

    private boolean restartOrStop() {
        String userInput = Console.readLine();

        if (userInput.equals(Constants.RESTART)) {
            answer = new RandomAnswer().generate();
            return true;
        } else if (userInput.equals(Constants.EXIT)) {
            return false;
        } else {
            throw new IllegalArgumentException(Constants.INPUT_ERROR_MSG);
        }
    }
}
