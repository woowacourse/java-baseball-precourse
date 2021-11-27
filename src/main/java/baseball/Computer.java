package baseball;

import static util.GameConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final int[] eachDigitOfGuessNumber = new int[NUMBER_LENGTH];
    private final int[] answerMadeByComputer = new int[NUMBER_LENGTH];

    public void makeThreeDigitNumber() {
        makeEachDigitUsingRandom();
    }

    private void makeEachDigitUsingRandom() {
        boolean[] alreadyUse = new boolean[MAX_RANGE + 1];
        int randomNumber;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            while (alreadyUse[randomNumber]) {
                randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
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
        for (int digitOfGuessNumber = 0; digitOfGuessNumber < NUMBER_LENGTH; digitOfGuessNumber++) {
            if (isStrike(digitOfGuessNumber)) {
                strikeCnt += 1;
            } else if (isBall(digitOfGuessNumber)) {
                ballCnt += 1;
            }
        }
        return new Result(strikeCnt, ballCnt);
    }

    private boolean isStrike(int digitOfGuessNumber) {
        return eachDigitOfGuessNumber[digitOfGuessNumber] == answerMadeByComputer[digitOfGuessNumber];
    }

    private boolean isBall(int digitOfGuessNumber) {
        for (int digitOfAnswer = 0; digitOfAnswer < NUMBER_LENGTH; digitOfAnswer++) {
            if (eachDigitOfGuessNumber[digitOfGuessNumber] == answerMadeByComputer[digitOfAnswer]) {
                return true;
            }
        }
        return false;
    }

    private void putGuessNumberInArray(int guessNumber) {
        eachDigitOfGuessNumber[0] = guessNumber / 100;
        guessNumber %= 100;

        eachDigitOfGuessNumber[1] = guessNumber / 10;
        guessNumber %= 10;

        eachDigitOfGuessNumber[2] = guessNumber;
    }
}
