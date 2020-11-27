package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class Opponent {
    int firstNum;
    int secondNum;
    int thirdNum;

    public void generator() {
        ArrayList<Integer> opponentNumberList = new ArrayList<>();
        while(opponentNumberList.size()<3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            if(!opponentNumberList.contains(randomNumber)) {
                opponentNumberList.add(randomNumber);
            }
        }
        this.firstNum = opponentNumberList.get(0);
        this.secondNum = opponentNumberList.get(1);
        this.thirdNum = opponentNumberList.get(2);
    }


}
