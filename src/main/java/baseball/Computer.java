package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int firstDigit;
    private int secondDigit;
    private int thirdDigit;

    public void makeThreeDigitNumber() {
        makeEachDigitUsingRandom();
        verifyEachDigitIsDuplicated();

        System.out.println("firstDigit = " + firstDigit);
        System.out.println("secondDigit = " + secondDigit);
        System.out.println("thirdDigit = " + thirdDigit);
    }

    private void verifyEachDigitIsDuplicated() {
        verifySecondDigitIsDuplicated();
        verifyThirdDigitIsDuplicated();
    }

    private void verifyThirdDigitIsDuplicated() {
        while (thirdDigit == firstDigit || thirdDigit == secondDigit) {
            thirdDigit = Randoms.pickNumberInRange(1, 9);
        }

    }

    private void verifySecondDigitIsDuplicated() {
        while (secondDigit == firstDigit) {
            this.secondDigit = Randoms.pickNumberInRange(1, 9);
        }
    }

    private void makeEachDigitUsingRandom() {
        this.firstDigit = Randoms.pickNumberInRange(1, 9);
        this.secondDigit = Randoms.pickNumberInRange(1, 9);
        this.thirdDigit = Randoms.pickNumberInRange(1, 9);
    }

}