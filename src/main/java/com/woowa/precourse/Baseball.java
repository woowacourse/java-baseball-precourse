package com.woowa.precourse;

public interface Baseball {

    public int[] makeThreeRandomNumbers();
    public int[] inputUserNumbers(); 
    public boolean checkInputNumbers(String inputNumber);
    public boolean checkDuplicate(int[] intArray, int index);
    public int[] convertStringToIntArray(String inputNumber); 
    public boolean checkNumberOrNot(String inputNumber); 
    public boolean checkInputNumberLength(String inputNumber); 
    public int[] checkStrikeOrBall(int[] comNumbers, int[] userNumbers);
    public void runGame(); 
    public void reGame();

}