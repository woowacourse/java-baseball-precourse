package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int makeRandomNumber(int digit) {
        StringBuilder randomNumber = new StringBuilder();
        while (randomNumber.length() < digit) {
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!randomNumber.toString().contains(number)) {
                randomNumber.append(number);
            }
        }
        return Integer.parseInt(randomNumber.toString());
    }
}
