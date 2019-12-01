package Baseball;

public class ScoreCheck {
    private int randomNumber;
    private int inputNumber;
    private int strike;
    private int ball;
    private boolean[] usedNumber_randomNumber;

    public ScoreCheck(int randomNumber, int inputNumber,boolean[] usedNumber){
        this.randomNumber = randomNumber;
        this.inputNumber = inputNumber;
        this.usedNumber_randomNumber = usedNumber;
    }

    private void checkStrike_Ball(){
        int toCheckRandomNumber = randomNumber;
        int toCheckInputNumber = inputNumber;
        strike = 0;

        while(toCheckRandomNumber != 0){
            int digit_randomNumber = toCheckRandomNumber % 10;
            int digit_inputNumber = toCheckInputNumber % 10;
            if(digit_randomNumber == digit_inputNumber){
                strike++;
            }else if(usedNumber_randomNumber[digit_inputNumber]){
                ball++;
            }

            toCheckRandomNumber /= 10;
            toCheckInputNumber /= 10;
        }
    }

    public int scoreResult(){
        checkStrike_Ball();
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
