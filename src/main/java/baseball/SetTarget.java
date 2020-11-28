package baseball;

import java.util.ArrayList;

public class SetTarget {

    public static ArrayList<Integer> setTargetList(){
        ArrayList<Integer> target = new ArrayList<Integer>();
        int i = 0;
        while (i < Application.TARGET_LENGTH) {
            int newNumber = getRandomNumber();
            i += addNewNumber(target, newNumber);
        }
        return target;
    }

    static int getRandomNumber(){
        return utils.RandomUtils.nextInt(1, 9);
    }

    static int addNewNumber(ArrayList<Integer> target, int newNumber){
        boolean isContain = Check.isContain(target, newNumber);
        if(!isContain){
            target.add(newNumber);
            return 1;
        }
        return 0;
    }
}
