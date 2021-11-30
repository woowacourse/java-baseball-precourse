package baseball;

import baseball.exception.WrongGuessException;


public class MarkingManager {

    private int[] answerArray;
    private int strike;
    private int ball;

    public MarkingManager(int[] answerArray) {
        this.answerArray = answerArray;
    }

    /**
     * 게임 재시작시, 정답을 설정
     * @param answerArray 새로운 정답
     */
    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    /**
     * 게임 플레이어가 입력한 답에서 strike를 확인
     * @param guessArray 입력한 정답
     */
    public void markStrike(int[] guessArray) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] == guessArray[i]) {
                strike ++;
            }
        }
        this.strike = strike;
    }

    /**
     * 게임 플레이어가 입력한답에서 ball 확인
     * @param guessArray 입력한 정답
     */
    public void markBall(int[] guessArray) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] != guessArray[i] && checkContain(guessArray[i])) {
                ball++;
            }
        }
        this.ball = ball;
    }

    /**
     * guessInt가 answerArray에 포함되어있는지 확인
     * @param guessInt 플레이어가 입력한 숫자들 중 하나
     * @return 포함되어있을 경우 true
     */
    public boolean checkContain(int guessInt) {
        for (int i = 0; i < 3; i++) {
            if (answerArray[i] == guessInt) {
                return true;
            }
        }
        return false;
    }

    /**
     * 게임 플레이어가 입력한 정답을 채점
     * @param guessArray 플레이어가 입력한 정답
     * @throws WrongGuessException 입력한 정답이 틀렸을 경우
     */
    public void mark(int[] guessArray) throws WrongGuessException {
        markStrike(guessArray);
        markBall(guessArray);
        if (strike == 3) {
            guessRight();
        } else {
            guessWrong();
            throw new WrongGuessException();
        }
    }

    /**
     * 게임 플레이어가 입력한 정답이 맞을 경우 메세지 출력
     */
    public void guessRight() {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 게임 플레이어가 입력한 정답이 틀릴 경우 메세지 출력
     */
    public void guessWrong() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike != 0 && ball == 0) {
            System.out.println(String.format("%d스트라이크", strike));
        } else if (strike == 0 && ball != 0) {
            System.out.println(String.format("%d볼", ball));
        } else {
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }
    }

}
