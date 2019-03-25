/*
 *  @(#)Computer.java       1.00    2019/03/24
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;


import java.io.IOException;

/**
 * Computer Class는 컴퓨터를 위한 클래스이다.
 * Player interface를 구현한다.
 * 인스턴스 변수인 numbers 배열이 있다. 이 배열은 컴퓨터가 랜덤으로 생성한 세 자리의 수를 저장하기 위한 배열이다.
 * 세 수를 생성하는 메서드가 있다.
 *
 * @version        1.00     2019년   3월  24일
 * @author         사명기
 */
public class Computer implements Player{

    /** 인스턴스 변수 numbers는 Computer가 생성한 세 자리의 수를 저장하기위한 배열 */
    private int[] numbers;

    /**
     *  매개변수가 없는 기본 생성자
     */
    public Computer(){
    }

    /**
     * 인스턴스 변수 numbers의 Setter
     * @param numbers
     */
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * 인스턴스 변수 numbers의 getter
     * @return
     */
    @Override
    public int[] getNumbers() {
        return numbers;
    }

    @Override
    public boolean isContinue() {
        return false;
    }

    /**
     * 랜덤한 수를 만들어서 배열에 담아 배열을 반환하는 메서드.
     * @return randomNumber Array
     */
    private int[] makeRandomNumber(){
        int[] randomNumber=new int[3];
        for(int i=0;i<3;i++){
            randomNumber[i]=(int)(Math.random()*9)+1;       // 1~9까지의 수를 랜덤하게 만들어서 배열에 저장.
        }
        return randomNumber;
    }

    /**
     * makerRandomNumber에서 만든 랜덤 수 배열을 확인하기 위한 메서드.
     * @param randomNumber  makeRandomNumber 메서드에서 만든 배열을 파라미터로 넣음
     * @return   세 숫자가 모두 다르면 true, 같은 숫자가 있을 경우 false 반환.
     */
    public boolean isValid(int[] randomNumber){
        /* 세 숫자가 모두 다르면 true, 같은 숫자가 있을 경우 false 반환 */
        return (randomNumber[0]!=randomNumber[1]) && (randomNumber[1]!=randomNumber[2])
                && (randomNumber[0]!=randomNumber[2]);
    }

    /**
     * 랜덤한 수를 만들어 저장하는 과정까지 담은 메서드.
     */
    @Override
    public void makeNewNumber() {
        int[] randomNumber;         // 임시 저장 배열

        do {
            randomNumber = this.makeRandomNumber();     // 임시 배열에 랜덤 수 만든 배열 넣음.
        } while (!isValid(randomNumber));               // 유효한지 판단. 중복된 수가 있으면 다시 랜덤수 만듬.

        this.setNumbers(randomNumber);                  // 랜덤 배열을 setter를 사용해 인스턴스 변수에 저장.
    }

    @Override
    public String toString(){
        return this.getNumbers()[0]+""+this.getNumbers()[1]+""+this.getNumbers()[2];
    }
}
