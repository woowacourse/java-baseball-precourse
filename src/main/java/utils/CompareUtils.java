package utils;

import number.PlayerNumber;
import number.RandomNumber;

/**
 * @author junyoung.choi
 */
public class CompareUtils {

    private static int strike;
    private static int ball;
    private static int[] ranNum;
    private static int[] playNum;

    CompareUtils(){
    }

    public static void compareNumber(RandomNumber randomNumber, PlayerNumber playerNumber){
        ranNum = randomNumber.getRandomNumber();
        playNum = playerNumber.getPlayerNumber();

        strike =0;
        ball = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                checkStrikeBall(i,j);
            }
        }
    }

    public static void checkStrikeBall(int i, int j){
        if(ranNum[i] == playNum[j]){
            if(i==j){
                strike++;
            }else{
                ball++;
            }
        }
    }

    public static int getStrike(){
        return strike;
    }

    public static int getBall(){
        return ball;
    }


}
