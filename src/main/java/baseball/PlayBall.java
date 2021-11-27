package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.IntStream;

public class PlayBall {
    private static final int DIGIT_NUM=3;

    public static void play(int[] generatedNumbers){
        while(true){
            int[] guessNumbers=getUserInput();
            String guessResult=guessNumber(generatedNumbers,guessNumbers);
            System.out.println(guessResult);

            if(isFinished(guessResult)){
                System.out.println("3개의 숫자를 모두 맞추면 게임 종료");
                return;
            }
        }
    }
    public static boolean isFinished(String guessResult){
        return guessResult.equals("3스트라이크");
    }

    private static int[] getUserInput(){

        System.out.print("숫자를 입력해주세요: ");
        String input=Console.readLine();

        if(!BaseBallUtil.isValidateGuess(input)) {throw new IllegalArgumentException("잘못된 입력입니다.");}
        return parseStringToIntegerArray(input);

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

        return (IntStream.of(generateNumbers).anyMatch(x -> x == guessNumbers[index]) && generateNumbers[index]!=guessNumbers[index]);

    }

    private static int[] parseStringToIntegerArray(String input){
        int[] guessNumber=new int[DIGIT_NUM];

        for(int i=0; i<DIGIT_NUM; i++)
        {
            guessNumber[i]= Integer.parseInt(input.substring(i,i+1));
        }
        return guessNumber;
    }
}
