package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    public static List<Integer> answer;
    public static boolean isContinue = true;
    
    BaseballGame() {
        BaseballGame.answer = new RandomAnswer().generate();
    }
    
    public void playGame() {
        while (isContinue) {
            // System.out.println(BaseballGame.answer);
            System.out.print(Constants.INPUT_NUMBER_MSG);
            String userInput = Console.readLine();
            userInput = UserInputValidator.playGameInput(userInput);
            System.out.println(judgeBallsAndStrikes(userInput));
        }  
    }
    
    public String judgeBallsAndStrikes(String userInput) {
        int balls = 0;
        for (int i=0; i<Constants.ANSWER_LENGTH; i++) {
            int target = Character.getNumericValue(userInput.charAt(i));
            if (answer.get(i) != target && answer.contains(target)) {
                balls++;
            }
        }
        
        int strikes = 0;
        for (int i=0; i<Constants.ANSWER_LENGTH; i++) {
            int target = Character.getNumericValue(userInput.charAt(i));
            if (answer.get(i) == target) {
                strikes++;
            }
        }
        
        if (strikes == 3) {
            isContinue = false;
        }
        
        String resultMessage = "";
        if (balls != 0) {
            resultMessage += Integer.toString(balls) + Constants.BALL;
        }
        
        if (resultMessage != "") {
            resultMessage += " ";
        }
        
        if (strikes != 0) {
            resultMessage += Integer.toString(strikes) + Constants.STRIKE;
        }
        
        if (balls == 0 && strikes == 0) {
            resultMessage = Constants.NOTHING;
        }
        
        return resultMessage;
    }
    
    public void restartOrExit() {
        System.out.println(Constants.GAME_RESTART_MSG);
        String userInput = Console.readLine();
        userInput = UserInputValidator.restartOrExitInput(userInput);
        
        if (userInput.equals(Constants.RESTART)) {
            isContinue = true;
            BaseballGame game = new BaseballGame();
            game.start();
        }
        
        if (userInput.equals(Constants.EXIT)) {
            System.out.println(Constants.GAME_EXIT_MSG);
        }
    }
    
    public void start() {
        System.out.println(Constants.GAME_START_MSG);
        
        playGame();
        
        System.out.println(Constants.GAME_END_MSG);
      
        restartOrExit();
    }
}