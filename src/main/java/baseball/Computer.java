package baseball;

import java.util.stream.IntStream;

public class Computer {
    private int num[];

    private void makeRandomNumber(){
        num = new int[3];

        num[0] = (int)(Math.random()*9 + 1);
        num[1] = (int)(Math.random()*9 + 1);

        while (num[0] == num[1]){
            num[1] = (int)(Math.random()*9 + 1);
        }
        num[2] = (int)(Math.random()*9 + 1);

        while ((num[0] == num[2]) || (num[1] == num[2])){
            num[2] = (int)(Math.random()*9 + 1);
        }
    }

    private int countBall(int[] userNum){
        return IntStream.range(0,3)
                .map(i -> (num[i] == userNum[(i+1)%3]) || (num[i] == userNum[(i+2)%3]) ? 1:0)
                .sum();
    }

    private int countStrike(int[] userNum){
        return IntStream.range(0,3)
                .map(i -> (num[i] == userNum[i]) ? 1:0)
                .sum();
    }

}
