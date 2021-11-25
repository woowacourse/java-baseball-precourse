package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    int[] eachDigitOfGuessNumber = new int[3];
    int[] answer = new int[3];

    public void makeThreeDigitNumber() {
        makeEachDigitUsingRandom();
        verifyEachDigitIsDuplicated();
//        System.out.println("정답 : "+ Integer.toString(firstDigit) + Integer.toString(secondDigit) + Integer.toString(thirdDigit)); // 정답을 가르쳐주는 코드. 테스트를 편하게 하기 위해서
    }

    private void verifyEachDigitIsDuplicated() {
        verifySecondDigitIsDuplicated();
        verifyThirdDigitIsDuplicated();
    }

    private void verifyThirdDigitIsDuplicated() {
        while (answer[2] == answer[0] || answer[2] == answer[1]) {
            answer[2] = Randoms.pickNumberInRange(1, 9);
        }

    }

    private void verifySecondDigitIsDuplicated() {
        while (answer[1] == answer[0]) {
            this.answer[1] = Randoms.pickNumberInRange(1, 9);
        }
    }

    private void makeEachDigitUsingRandom() {
        answer[0] = Randoms.pickNumberInRange(1, 9);
        answer[1] = Randoms.pickNumberInRange(1, 9);
        answer[2] = Randoms.pickNumberInRange(1, 9);
    }

    public Result compareGuessNumberAndAnswer(int guessNumber) {
        putGuessNumberInArray(guessNumber);
        return makeResult();
    }

    private Result makeResult() {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (eachDigitOfGuessNumber[i] == answer[i]) {
                strikeCnt += 1;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (eachDigitOfGuessNumber[i] == answer[j]) {
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