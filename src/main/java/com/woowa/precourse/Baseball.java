/*
 * @Baseball.java        1.00 2019/03/26
 * 
 * Copyright(c) 2019         Soojin Roh
 * All rights reserved.
 * 
 * BaseballGame.java에서 작성할 추상 method를 구현한 interface입니다.
 */

package com.woowa.precourse;

public interface Baseball {

    abstract int[] makeThreeRandomNumbers();
    abstract int[] inputUserNumbers(); 
    abstract boolean checkInputNumbers(String inputNumber);
    abstract boolean checkDuplicate(int[] intArray, int index);
    abstract int[] convertStringToIntArray(String inputNumber); 
    abstract boolean checkNumberOrNot(String inputNumber); 
    abstract boolean checkInputNumberLength(String inputNumber); 
    abstract int[] checkStrikeOrBall(int[] comNumbers, int[] userNumbers);
    abstract void runGame(); 
    abstract void reGame();

}