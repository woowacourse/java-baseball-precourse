package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static boolean EXIT = false;
    static boolean REPLAY = true;

    public static void main(String[] args) {
        while (true) {
            boolean gameResult = PlayGame();
            boolean replayOrExit = DecideReplayOrExit(gameResult);

            if (replayOrExit == EXIT) {
                break;
            }
        }
    }

    static boolean GAME_ERROR=false;
    static boolean GAME_NORMAL=true;

    static boolean CORRECT_INPUT=true;
    static boolean WRONG_INPUT=false;

    static boolean PlayGame(){
        String keyNumbers = SelectRandomNumbers();
        while(true){
            String inputNumbers = GetInputNumbers();

            if(IsInputError(inputNumbers)){
                return GAME_ERROR;
            }

            boolean inputResult = CheckInputNumbers(keyNumbers,inputNumbers);
            if(inputResult==CORRECT_INPUT){
                return GAME_NORMAL;
            }
        }
    }

    static boolean DecideReplayOrExit(String gameResult){

    }

}
