package indi.moon.firstweek;

public class Referee implements Refereeface {

    public int countStrike(int[]answer, int[]calledAnswer){
        int strike = 0;
        for(int i = 0; i<3; i++) {
            if (answer[i] == calledAnswer[i]) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(int[]answer, int[]calledAnswer){
        int ball = 0;
        for(int i =0; i<3; i++){
            int index = indexOf(answer,calledAnswer[i]);
            if(index != -1){
                ball++;
            }
        }
        return ball;
    }

    public int indexOf(int[] array, int key) {
        int value = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                value = i;
                break;
            }
        }
        return value;
    }

}
