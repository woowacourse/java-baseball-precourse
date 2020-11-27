package modules;

import java.util.ArrayList;
import utils.RandomUtils;

public class NumberGenerator {
    static final int NUMBER_RANGE_MIN = 1;
    static final int NUMBER_RANGE_MAX = 9;
    static final int NUMBER_SIZE = 3;

    private ArrayList<Integer> numberRange;
    private int[] generatedNumber;

    public int[] getNumber(){
        return generatedNumber.clone();
    }

    public void generate(){
        initializeNumberRange();
        generatedNumber = new int[NUMBER_SIZE];
        for(int i = 0; i < generatedNumber.length; i++){
            generatedNumber[i] = popFromNumberRange();
        }
    }
    
    private void initializeNumberRange(){
        numberRange = new ArrayList<Integer>();

        for(int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++){
            numberRange.add(i);
        }
    }

    private int popFromNumberRange(){
        int index = getRandomIndexOfNumberRange();
        int popValue = numberRange.get(index);
        numberRange.remove(index);
        return popValue;
    }

    private int getRandomIndexOfNumberRange(){
        return RandomUtils.nextInt(0, numberRange.size() - 1);
    }
}