package baseball.umpire;


import java.util.Arrays;

public class Umpire {
    public int strike;
    public int ball;

    public Umpire(){
        strike=0;
        ball=0;
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
