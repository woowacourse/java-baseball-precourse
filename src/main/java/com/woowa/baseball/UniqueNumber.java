/**
 * UniqueNumber.java
 */


package com.woowa.baseball;


/**
 * UniqueNumber클래스는 숫자 야구 게임의 정답을 담고 있으며,
 * 사용자의 입력과 비교하여 힌트를 생성하는 클래스입니다.
 *
 * @version     1.0
 * @since       03/24/2019
 * @author      icarus8050
 */
public class UniqueNumber {

    private int[] answerNumber;

    /**
     * @param answerNumber UniqueNumberMaker 객체로부터 생성된 유니크한 숫자 배열
     */
    public UniqueNumber(int[] answerNumber) {
        this.answerNumber = answerNumber;
    }

    /**
     * 사용자로부터 입력받은 숫자와 정답을 비교하여 힌트를 생성하는 메서드
     *
     * @param queryNumber 사용자가 입력한 유니크한 숫자 배열
     * @return 사용자가 입력한 숫자와 정답을 비교하여 생성한 힌트 배열
     *          [0] = Strike 개수, [1] = Ball 개수를 나타냄
     */
    public int[] compareAnswer(int[] queryNumber) {

        /* hint[0] = Strike 개수, hint[1] = Ball 개수 */
        int[] hint = {0, 0};

        for (int i = 0; i < queryNumber.length; i++) {
            HintType hintType = getHint(i, queryNumber[i]);

            if (hintType == HintType.STRIKE){
                hint[0]++;
            } else if (hintType == HintType.BALL) {
                hint[1]++;
            }
        }

        return hint;
    }

    /**
     * 숫자가 정답과 같은 숫자가 있다면 위치에 따라 Strike인지, Ball인지 판별함.
     *
     * @param numberPosition  사용자가 입력한 숫자중 하나의 위치
     * @param number          numberPosition 위치의 숫자
     * @return                숫자에 대한 힌트 판별 값
     */
    private HintType getHint(int numberPosition, int number) {
        HintType hintType = HintType.NOTHING;

        for (int i = 0; i < answerNumber.length; i++) {
            if (answerNumber[i] == number) {

                /* 정답 숫자 중에 number와 같은 숫자가 있다면
                 * 두 숫자의 위치가 같은지 확인한다.
                 */
                hintType = checkPosition(i, numberPosition);
                break;
            }
        }

        return hintType;
    }

    /**
     * 정답과 질의한 숫자가 일치할 때, 위치가 서로 같은지 판별하는 메서드
     *
     * @param answerNumberPos   정답 숫자의 위치
     * @param queryNumberPos    질의한 숫자의 위치
     * @return                  위치가 같다면 STRIKE, 다르면 BALL
     */
    private HintType checkPosition(int answerNumberPos, int queryNumberPos){
        return ((answerNumberPos == queryNumberPos)
                ? HintType.STRIKE
                : HintType.BALL);
    }
}
