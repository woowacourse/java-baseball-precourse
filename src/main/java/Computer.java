/*
 * Player1(컴퓨터)의 숫자를 생성하기 위한 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.02
 * 
 * @author Jung dahee
 */

public class Computer {
	
    public static String make(){
        double randomValue = Math.random();
        int tempNum = (int) (randomValue * 865) + 123;
        
        return Integer.toString(tempNum);
    }
}
