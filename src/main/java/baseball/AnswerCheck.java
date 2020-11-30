package baseball;

import java.util.Arrays;

public class AnswerCheck {
    public static int[] answerCheck(int[] computerNumber, int[] userNumber, int validCountOfNumber){
        int strike=0;
        int ball=0;
        for(int i=0;i<validCountOfNumber;i++){
            int findNumber = userNumber[i];
            if (computerNumber[i] == findNumber){
                strike++;
            }
            else if(Arrays.stream(computerNumber)
                .anyMatch(x -> x == findNumber)){
                ball++;
            }
        }
        return new int[]{strike, ball};
    }
}
