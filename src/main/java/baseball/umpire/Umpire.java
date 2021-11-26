package baseball.umpire;


import java.util.Arrays;

public class Umpire {
    public int strike;
    public int ball;

    public Umpire(){
        strike=0;
        ball=0;
    }

    public void checkResult(int[] target,int[] input){
        isStrike(target,input);
        isBall(target,input);
        if (strike==0 && ball==0){
            System.out.println("nothing");
            return ;
        }
        System.out.println(strike+"스트라이크");
        System.out.println(ball+"볼");

    }

    public boolean isEnd(){
        if (strike==3){
            return true;
        }
        return false;
    }

    public void isStrike(int[] target,int[] input){
        for(int i=0; i<3;i++){
            if (target[i]==input[i]){
                strike+=1;
            }
        }

    }
    public void isBall(int[] target,int[] input){
        for(int i=0; i<3;i++){
            if (contains(target,input[i],i)){
                ball+=1;
            }
        }
    }


    public boolean contains(int[] array, int key,int index) {
        for(int i=0;i<array.length;i++){
            if(i!=index && key==array[i]){
                return true;
            }
        }
        return false;
    }


}
