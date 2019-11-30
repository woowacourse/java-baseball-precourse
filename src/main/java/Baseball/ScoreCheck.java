package Baseball;

import javax.swing.*;

public class ScoreCheck {
    static private int randomNumber;
    static private int inputNumber;
    static private int strike;
    static private int ball;
    static private boolean[] usedNumber_randomNumber;

    public ScoreCheck(int randomNumber, int inputNumber,boolean[] usedNumber){
        this.randomNumber = randomNumber;
        this.inputNumber = inputNumber;
        this.usedNumber_randomNumber = usedNumber;
    }

    private void checkStrike(){
        int temp_random = randomNumber;
        int temp_input = inputNumber;
        strike = 0;

        while(temp_random != 0){
            int sep_randomNumber = temp_random%10;
            int sep_inputNumber = temp_input%10;
            if(sep_randomNumber == sep_inputNumber){
                strike++;
                usedNumber_randomNumber[sep_randomNumber] = false;
            }

            temp_random /= 10;
            temp_input /= 10;
        }
    }

    private void checkBall(){
        int temp_input = inputNumber;
        ball = 0;

        while(temp_input != 0){
            int sep_inputNumber = temp_input%10;
            if(usedNumber_randomNumber[sep_inputNumber]){
                ball++;
            }

            temp_input /= 10;
        }
    }

    public int scoreResult(){
        checkStrike();
        checkBall();
        print();
        return strike;
    }

    private void print(){
        if(strike == 0){
            if(ball == 0){
                System.out.println("낫싱");
            }else{
                System.out.println(ball+" 볼");
            }
        }else{
            if(ball == 0){
                System.out.println(strike +" 스트라이크");
            }else{
                System.out.println(strike + " 스트라이크 " + ball + " 볼");
            }
        }
    }
}
