import java.util.ArrayList;
import utils.ConvertUtils;
import utils.InputUtils;
import utils.RuleUtils;

public class PlayerPerson extends Player {

    public void makeNumbers(){
        ArrayList<Integer> inputNumbers;
        while(true){
            Integer input= InputUtils.inputInteger("숫자를 입력해주세요 : ");
            inputNumbers= ConvertUtils.toDigitArrayList(input);
            if(RuleUtils.isValidDigit(inputNumbers)==true&&RuleUtils.isValidRange(inputNumbers)==true) {
                break;
            }else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
        super.numbers=inputNumbers;
        makeNumbersCounts();
    }
}