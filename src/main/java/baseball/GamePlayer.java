package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameValidator.*;
import static util.GameConstant.INVALID_INPUT_ERROR;
import static util.GameConstant.NUMBER_LENGTH;

public class GamePlayer {
    private int[] playerAnswer = new int[NUMBER_LENGTH];

    public void writeAnswer(){
        String input = Console.readLine();
        if(!isValidInput(input)){
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        putInputOnPlayerAnswer(input);
    }

    private void putInputOnPlayerAnswer(String input){
        for(int i = 0 ; i < NUMBER_LENGTH; i++){
            playerAnswer[i] = convertCharToInt(input.charAt(i));
        }
    }

    private int convertCharToInt(char digit){
        return digit - '0';
    }
}
