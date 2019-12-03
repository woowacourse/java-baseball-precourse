import java.util.ArrayList;
import java.util.Arrays;

import utils.RuleUtils;

public abstract class Player {
    ArrayList<Integer> numbers;
    ArrayList<Integer> numberCounts;
    public void makeNumbersCounts(){
        if(numbers==null) return;
        Integer counts[]=new Integer[RuleUtils.UPPERBOUND-RuleUtils.LOWERBOUND+1];
        Arrays.fill(counts,0);
        for(int i :numbers){
            int idx=i-RuleUtils.LOWERBOUND;
            counts[idx]+=1;
        }
        numberCounts=new ArrayList<Integer>(Arrays.asList(counts));
    }
    abstract public void makeNumbers();
}