package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameValidator.*;
import static util.GameConstant.*;

class GamePlayer {
    private int[] playerAnswer = new int[NUMBER_LENGTH];

    public void insertAnswer(){
        System.out.print(REQUEST_INPUT);
        String input = Console.readLine();
        if(!isValidInput(input)){
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        addPlayerAnswer(input);
    }

    private void addPlayerAnswer(String input){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            playerAnswer[i] = convertCharToInt(input.charAt(i));
        }
    }

    private int convertCharToInt(char digit){
        return Character.getNumericValue(digit);
    }

    public String insertRestartOrStop(){
        System.out.println(ASK_RESTART_OR_STOP);
        String input = Console.readLine();
        isRightInputRestartOrStop(input);
        return input;
    }

    private void isRightInputRestartOrStop(String input){
        if(!input.equals(RESTART) && !input.equals(STOP)){
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public int[] getPlayerAnswer() {
        return playerAnswer;
    }
}
