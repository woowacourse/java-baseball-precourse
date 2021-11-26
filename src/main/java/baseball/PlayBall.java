package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class PlayBall {
    private static final int DIGIT_NUM=3;

    public static void play(int[] generatedNumbers){
        while(true){
            int[] guessNumbers=getUserInput();
            String guessResult=guessNumber(generatedNumbers,getUserInput());
            System.out.println(guessResult);

            if(isFinished(guessResult)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }
    public static boolean isFinished(String guessResult){
        return guessResult.equals("3스트라이크");
    }

    private static int[] getUserInput(){

        String input=Console.readLine();

        if(isValidate(input)) return parseStringToIntegerArray(input);
        else throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static boolean isValidate(String input){
        if(input.length()!=DIGIT_NUM) return false;
        if(!isNumberFormat(input)) return false;
        if(!isZeroInNumber(input)) return false;

        return true;
    }

    private static boolean isZeroInNumber(String input){
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='0') return false;
        }
        return true;
    }

    private static boolean isNumberFormat(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static String guessNumber(int[] generateNumbers, int[] guessNumbers){
        int strike_num=getStrikeCount(generateNumbers, guessNumbers);
        int ball_num=getBallCount(generateNumbers, guessNumbers);
        GameStatus gameStatus=new GameStatus(strike_num, ball_num);

        return gameStatus.toString();
    }

    public static int getStrikeCount(int[] generateNumbers, int[] guessNumbers){
        int strike_num=0;
        for(int i=0; i<DIGIT_NUM; i++)
        {
            if(generateNumbers[i]==guessNumbers[i]) strike_num++;
        }
        return strike_num;
    }

    public static int getBallCount(int[] generateNumbers, int[] guessNumbers){
        int ball_num=0;
        for(int i=0; i<DIGIT_NUM; i++){
            if(isBall(generateNumbers, guessNumbers, i)) ball_num++;
        }
        return ball_num;
    }

    public static boolean isBall(int[] generateNumbers, int[] guessNumbers, int index){
        if(Arrays.asList(generateNumbers).contains(guessNumbers[index]) && generateNumbers[index]!=guessNumbers[index]){
            return true;
        }
        return false;
    }

    private static int[] parseStringToIntegerArray(String input){
        int[] guessNumber=new int[DIGIT_NUM];

        for(int i=0; i<DIGIT_NUM; i++)
        {
            guessNumber[i]=input.charAt(i);
        }
        return guessNumber;
    }
}
