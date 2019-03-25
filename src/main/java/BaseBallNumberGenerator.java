import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBallNumberGenerator {
    public static final int BASEBALL_NUMBER_COUNTING_SIZE = 3;
    private List<BaseNumber> baseBallNumbers = new ArrayList<>();

    public BaseBallNumberGenerator() {
        Random random = new Random();

        while(baseBallNumbers.size() < BASEBALL_NUMBER_COUNTING_SIZE) {
            int number = random.nextInt(BaseNumber.BASE_NUMBER_MAX) + BaseNumber.BASE_NUMBER_MIN;
            if(assertDuplicateNumber(baseBallNumbers, number) == false) {
                baseBallNumbers.add(BaseNumber.valueOf(number));
            }
        }
    }

    private boolean assertDuplicateNumber(List<BaseNumber> baseBallNumbers, int number) {
        return (baseBallNumbers.contains(BaseNumber.valueOf(number)))? true: false;
    }

    public List<BaseNumber> getBaseBallNumbers() {
        return baseBallNumbers;
    }
} 
