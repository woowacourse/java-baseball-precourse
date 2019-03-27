/*
 * Player
 * 
 * version 1.0
 * 
 * 2019. 3. 27
 * 
 * Created by Wongeun Song
 */

import java.util.Scanner;

public class Player {
	int[] numbers = new int[3];
	char[] charNumbers = new char[3];
	String stringNumber;
	
	public void inputNumbers() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요: ");
		stringNumber = scan.nextLine();
	}
	
	public void convertStringToCharacter() {
		charNumbers[0] = stringNumber.charAt(0);
		charNumbers[1] = stringNumber.charAt(1);
		charNumbers[2] = stringNumber.charAt(2);
	}
	
	public void convertCharacterToInt() {
		numbers[0] = Character.getNumericValue(charNumbers[0]);
		numbers[1] = Character.getNumericValue(charNumbers[1]);
		numbers[2] = Character.getNumericValue(charNumbers[2]);
	}
	
	/**
	 * 입력받은 문자열이 세자리인지 판단
	 * @return 3자리이면 true, 아니면 false
	 */
	public boolean isCollectLength() {
		return stringNumber.length() == 3;
	}
	
	/**
	 * 입력받은 문자열을 변환한 Character가 숫자인지 판단
	 * @return 모두 숫자면 true, 아니면 false
	 */
	public boolean isNumber() {
		return ('0' <= charNumbers[0] && charNumbers[0] <= '9') 
					&& ('0' <= charNumbers[1] && charNumbers[1] <= '9')
					&& ('0' <= charNumbers[2] && charNumbers[2] <= '9');
	}
	
	/**
	 * 숫자간에 중복이 있는지 판단
	 * @return 중복이면 true, 아니면 false
	 */
	public boolean hasDuplicated() {
		return (charNumbers[0] == charNumbers[1])
					|| (charNumbers[0] == charNumbers[2])
					|| (charNumbers[1] == charNumbers[2]);
	}
	
}
