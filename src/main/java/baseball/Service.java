package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Service {

    public ArrayList<Integer> generate() {
        ArrayList<Integer> opponentNumberList = new ArrayList<>();
        while(opponentNumberList.size()<3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            if(!opponentNumberList.contains(randomNumber)) {
                opponentNumberList.add(randomNumber);
            }
        }
        return opponentNumberList;
    }

    public boolean filter(String playerNum) {
        if(playerNum.length()!=3 || playerNum.contains("0")) {
            throw new IllegalArgumentException();
        }

        Set set = new HashSet();
        for(String data : playerNum.split("")) {
            set.add(data);
        }
        if(set.size()!=3) {
            throw new IllegalArgumentException();
        }

        return true;
    }


}
