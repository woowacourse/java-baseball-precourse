package baseball;

import utils.Checker;
import utils.RandomUtils;

public class Number {

    private int[] target;
    private int[] guess;

    public Number() {
        target = new int[3];
        guess = new int[3];
    }

    public void setTarget(){
        for(int i = 0; i < 3; i++){
            int tmp = RandomUtils.nextInt(1, 9);
            if(!Checker.checkDuplicateNumber(tmp)){
                target[i] = tmp;
            }
            else{
                i--;
            }
        }
    }

    public void setGuess(String input) throws IllegalArgumentException{
        if(input.length() != 3){
            throw new IllegalArgumentException("Wrong numberLength");
        }
        for(int c=0; c < input.length(); c++){
            if(Checker.checkInput(input.charAt(c))){
                guess[c] = input.charAt(c) - '0';
            }
            else{
                throw new IllegalArgumentException("Wrong number");
            }
        }
    }

    public int strike(){
        int strikeCnt=0;
        for(int i = 0; i < 3; i++){
            if(guess[i]==target[i]){
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public int ball(){
        int ballCnt=0;
        for(int i = 0; i < 3; i++){
            if(Checker.checkBall(guess[i], target, i)){
                ballCnt++;
            }
        }
        return ballCnt;
    }
}
