package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ThreeDigitGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        List<Integer> generatedNumber = new ArrayList<>(3);

        int firstDigit = pickNumberInRange(1, 9);
        generatedNumber.add(firstDigit);

        int secondDigit = pickNumberInRange(1, 9);
        while(firstDigit == secondDigit) {
            secondDigit = pickNumberInRange(1, 9);
        }
        generatedNumber.add(secondDigit);

        int thirdDigit = pickNumberInRange(1, 9);
        while ((firstDigit == thirdDigit) || (secondDigit == thirdDigit)) {
            thirdDigit = pickNumberInRange(1, 9);
        }
        generatedNumber.add(thirdDigit);

        return generatedNumber;
    }
}
