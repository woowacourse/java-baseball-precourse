import java.util.ArrayList;
import java.util.Random;
import utils.RuleUtils;

public class PlayerBot extends Player {
    static RuleUtils ruleUtils;
    public void makeNumbers(){
        ArrayList<Integer> inputNumbers=new ArrayList<>();
        ArrayList<Integer> candidates= ruleUtils.makeInRangeList();
        Random random=new Random();
        for(int i = 0; i<RuleUtils.DIGITS; i++){
            int randomIndex=random.nextInt(candidates.size());
            inputNumbers.add(candidates.get(randomIndex));
            candidates.remove(randomIndex);
        }
        super.numbers=inputNumbers;
        makeNumbersCounts();
    }
}