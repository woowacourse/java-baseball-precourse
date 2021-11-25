package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int NUMBER_LEN = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private int[] eachDigitOfGuessNumber = new int[NUMBER_LEN];
    private int[] answerMadeByComputer = new int[NUMBER_LEN];

    public void makeThreeDigitNumber() {
        makeEachDigitUsingRandom();
//        System.out.println("정답 : "+ Integer.toString(answerMadeByComputer[0]) + Integer.toString(answerMadeByComputer[1]) + Integer.toString(answerMadeByComputer[2])); // 정답을 가르쳐주는 코드. 테스트를 편하게 하기 위해서
    }

    private void makeEachDigitUsingRandom() {
        boolean[] alreadyUse = new boolean[MAX_RANGE + 1];
        int randomNumber;
        for (int i = 0; i < NUMBER_LEN; i++) {
            randomNumber = Randoms.pickNumberInRange(MIN_RANGE,MAX_RANGE);
            while (alreadyUse[randomNumber]) {
                randomNumber = Randoms.pickNumberInRange(MIN_RANGE,MAX_RANGE);
            }
            answerMadeByComputer[i] = randomNumber;
            alreadyUse[randomNumber] = true;
        }
    }

    public Result compareGuessNumberAndAnswer(int guessNumber) {
        putGuessNumberInArray(guessNumber);
        return makeResult();
    }

    private Result makeResult() {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < NUMBER_LEN; i++) {
            if (eachDigitOfGuessNumber[i] == answerMadeByComputer[i]) {
                strikeCnt += 1;
                continue;
            }
            for (int j = 0; j < NUMBER_LEN; j++) {
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