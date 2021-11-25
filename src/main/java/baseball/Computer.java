package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private int[] eachDigitOfGuessNumber = new int[3];
    private int[] answerMadeByComputer = new int[3];

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
        while (answerMadeByComputer[2] == answerMadeByComputer[0] || answerMadeByComputer[2] == answerMadeByComputer[1]) {
            answerMadeByComputer[2] = Randoms.pickNumberInRange(1, 9);
        }

    }

    private void verifySecondDigitIsDuplicated() {
        while (answerMadeByComputer[1] == answerMadeByComputer[0]) {
            this.answerMadeByComputer[1] = Randoms.pickNumberInRange(1, 9);
        }
    }

    private void makeEachDigitUsingRandom() {
        answerMadeByComputer[0] = Randoms.pickNumberInRange(1, 9);
        answerMadeByComputer[1] = Randoms.pickNumberInRange(1, 9);
        answerMadeByComputer[2] = Randoms.pickNumberInRange(1, 9);
    }

    public Result compareGuessNumberAndAnswer(int guessNumber) {
        putGuessNumberInArray(guessNumber);
        return makeResult();
    }

    private Result makeResult() {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (eachDigitOfGuessNumber[i] == answerMadeByComputer[i]) {
                strikeCnt += 1;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (eachDigitOfGuessNumber[i] == answerMadeByComputer[j]) {
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