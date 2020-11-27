package baseball.modules;

import java.util.ArrayList;
import utils.RandomUtils;

public class NumberGenerator {
    static final int NUMBER_RANGE_MIN = 1;
    static final int NUMBER_RANGE_MAX = 9;

    private ArrayList<Integer> numberRange;
    private int[] generatedNumber;

    private int numberSize;

    public NumberGenerator(int numberSize){
        this.numberSize = numberSize;
    }

    public int[] getNumber(){
        return generatedNumber.clone();
    }

    public void generate(){
        initializeNumberRange();
        generatedNumber = new int[numberSize];
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