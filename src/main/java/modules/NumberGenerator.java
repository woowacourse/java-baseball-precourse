package modules;

import java.util.ArrayList;

public class NumberGenerator {
    private ArrayList<Integer> numberRange;
    static final int NUMBER_RANGE_MIN = 1;
    static final int NUMBER_RANGE_MAX = 9;
    
    private void initializeNumberRange(){
        numberRange = new ArrayList<Integer>();

        for(int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++){
            numberRange.add(i);
        }
    }
}