package utils;

import static utils.Constant.*;

public class OutputView {

    public static void printHint(int strike, int ball){
        if(strike == BALLS_LENGTH){
            System.out.println(strike+HINT_STRIKE);
        }else if (strike ==0 && ball ==0) {
            System.out.println(ball+HINT_NOTHING);
        }else if (strike == 0){
            System.out.println(ball+HINT_BALL);
        }else if (ball == 0){
            System.out.println(strike+HINT_STRIKE);
        }else{
            System.out.println(ball+HINT_BALL+" "+strike+HINT_STRIKE);
        }
    }
}
