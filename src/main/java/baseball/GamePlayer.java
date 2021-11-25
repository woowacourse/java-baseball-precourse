package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameValidator.*;
import static util.GameConstant.*;

class GamePlayer {
    private int[] playerAnswer = new int[NUMBER_LENGTH];

    public void writeAnswer(){
        System.out.print(REQUEST_INPUT);
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
        return Character.getNumericValue(digit);
    }

    public int[] getPlayerAnswer() {
        return playerAnswer;
    }
}
