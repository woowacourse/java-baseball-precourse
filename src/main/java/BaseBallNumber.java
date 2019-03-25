import java.util.ArrayList;
import java.util.List;

public class BaseBallNumber {
    public static final int BASEBALL_NUMBER_COUNTING_SIZE = 3;
    private List<BaseNumber> baseBallNumbers = new ArrayList<>();

    public BaseBallNumber(int baseBallNumber) {
        for(int i = BASEBALL_NUMBER_COUNTING_SIZE-1; i >= 0; i--) {
            int number = baseBallNumber / (int) Math.pow(10, i);
            assertDuplicateNumber(baseBallNumbers, number);
            baseBallNumbers.add(BaseNumber.valueOf(number));
            baseBallNumber -= number * Math.pow(10, i);
        }
    }

    private void assertDuplicateNumber(List<BaseNumber> baseBallNumbers, int number) {
        if(baseBallNumbers.contains(BaseNumber.valueOf(number))) {
            throw new IllegalArgumentException(String.format("숫자 %d가 중복되었습니다.", number));
        }
    }

    public List<BaseNumber> getBaseBallNumbers() {
        return baseBallNumbers;
    }

} 
