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


    static int MAX_NUMBER=9;
    static int MIN_NUMBER=1;
    static int NUMBER_COUNT=MAX_NUMBER-MIN_NUMBER+1;
    static int NUMBER_SIZE=3;

    static String SelectRandomNumbers(){
        boolean[] existence = new boolean[NUMBER_COUNT];
        int[] randomNumber = new int[NUMBER_SIZE];
        int randomNumberInt=0;

        for(int i=0;i<NUMBER_SIZE;++i){
            randomNumber[i]=pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
            if(existence[randomNumber[i]-MIN_NUMBER]){
                i--;
            } else{
                existence[randomNumber[i]-MIN_NUMBER]=true;
            }
        }

        for(int i=0;i<NUMBER_SIZE;++i){
            randomNumberInt*=10;
            randomNumberInt+=randomNumber[i];
        }

        String keyNumbers=Integer.toString(randomNumberInt);
        return keyNumbers;
    }

    static String GetInputNumbers(){
        System.out.print("숫자를 입력해주세요 : ");

        String inputNumbers = readLine();
        return inputNumbers;
    }

    static boolean INPUT_ERROR=true;
    static boolean NON_INPUT_ERROR=false;

    static boolean IsInputError(String inputNumbers){
        if(inputNumbers.length()!=NUMBER_SIZE){
            return INPUT_ERROR;
        }

        boolean[] existence=new boolean[NUMBER_COUNT];

        for(int i=0;i<NUMBER_SIZE;++i){
            if(inputNumbers.charAt(i)<'1' || '9'<inputNumbers.charAt(i)){
                return INPUT_ERROR;
            }
        }

        return NON_INPUT_ERROR;
    }

    static boolean CheckInputNumbers(String keyNumbers,String inputNumbers){
        int strikeCount = 0;
        int ballCount=0;

        for(int i=0;i<NUMBER_SIZE;++i){
            if(IsStrike(keyNumbers.charAt(i),inputNumbers.charAt(i))){
                strikeCount++;
            } else if(IsBall(keyNumbers,inputNumbers.charAt(i))){
                ballCount++;
            }
        }

        return ReturnInputResult(strikeCount,ballCount);
    }

    static boolean IsStrike(char keyNumbersChar, char inputNumbersChar){

    }
    static boolean IsBall(String keyNumbers, char inputNumbersChar){

    }

    static boolean ReturnInputResult(int strikeCount,int ballCount){

    }


    static boolean DecideReplayOrExit(String gameResult){

    }

}
