/*
 * EarlyResults
 * 2019.11.30
 * 숫자야구 중간결과
 */

package com.woowahan.baseball;

public class BallsResult {
    private int ballScore;
    private int strikeScore;

    public enum BallResult {
        NONE, BALL, STRIKE
    };

    private boolean isCorrect(){
        return strikeScore == 3;
    }

    private boolean isNothing(){
        return (strikeScore == 0) && (ballScore == 0);
    }

    private void printScore(){
        if (strikeScore != 0) {
            System.out.print(strikeScore + " 스트라이크 ");
        }
        if (ballScore != 0) {
            System.out.print(ballScore + "볼");
        }
        System.out.println();
    }

    public void addEarlyResult(BallResult one){
        if (one == BallResult.BALL){
            ballScore++;
        }
        if (one == BallResult.STRIKE){
            strikeScore++;
        }
    }

    public boolean printResults(){
        if (isCorrect()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (isNothing()){
            System.out.println("낫싱");
        }
        else {
            printScore();
        }

        return false;
    }

}