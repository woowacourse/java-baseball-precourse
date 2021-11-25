package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int firstDigit;
    private int secondDigit;
    private int thirdDigit;
    int[] eachDigitOfGuessNumber = new int[3];
    int[] answer = new int[3];

    public void makeThreeDigitNumber() {
        makeEachDigitUsingRandom();
        verifyEachDigitIsDuplicated();
    }

    private void verifyEachDigitIsDuplicated() {
        verifySecondDigitIsDuplicated();
        verifyThirdDigitIsDuplicated();
        answer[0] = firstDigit;
        answer[1] = secondDigit;
        answer[2] = thirdDigit;
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

    public Result compareGuessNumberAndAnswer(int guessNumber) {
        putGuessNumberInArray(guessNumber);
        return makeResult();
    }

    private Result makeResult() {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (answer[i] == eachDigitOfGuessNumber[i]) {
                strikeCnt += 1;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (answer[i] == eachDigitOfGuessNumber[j]) {
                    ballCnt += 1;
                }
            }
        }
        return new Result(strikeCnt, ballCnt);
    }

    private void putGuessNumberInArray(int guessNumber) {
        eachDigitOfGuessNumber[0] = guessNumber / 100;
        guessNumber %= 100;

        eachDigitOfGuessNumber[1] = guessNumber / 10;
        guessNumber %= 10;

        eachDigitOfGuessNumber[2] = guessNumber;
    }
}