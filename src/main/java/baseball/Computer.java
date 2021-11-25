package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private int[] eachDigitOfGuessNumber = new int[3];
    private int[] answerMadeByComputer = new int[3];
    boolean[] alreadyUse = new boolean[10];

    public void makeThreeDigitNumber() {
        while (true) {
            makeEachDigitUsingRandom();
//            System.out.println("정답 : "+ Integer.toString(answerMadeByComputer[0]) + Integer.toString(answerMadeByComputer[1]) + Integer.toString(answerMadeByComputer[2])); // 정답을 가르쳐주는 코드. 테스트를 편하게 하기 위해서

        }
    }

    private void makeEachDigitUsingRandom() {
        int randomNumber;
        for (int i = 0; i < 3; i++) {
            randomNumber = Randoms.pickNumberInRange(1,9);
            while (alreadyUse[randomNumber]) {
                randomNumber = Randoms.pickNumberInRange(1,9);
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