package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ThreeDigitGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        int firstDigit = pickNumberInRange(1, 9);
        int secondDigit = pickNumberInRange(1, 9);
        while(firstDigit == secondDigit) {
            secondDigit = pickNumberInRange(1, 9);
        }
        int thirdDigit = pickNumberInRange(1, 9);
        while ((firstDigit == thirdDigit) || (secondDigit == thirdDigit)) {
            thirdDigit = pickNumberInRange(1, 9);
        }
        return firstDigit * 100 + secondDigit * 10 + thirdDigit;
    }
}
