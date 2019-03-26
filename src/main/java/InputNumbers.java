/**
 * 이 클래스는 3개의 서로 다른 수를 입력받기위하나 클래스이다.
 * 클래스 생성과 동시에 연속된 1~9 사이의 서로 다른 자연수를 입력받아 배열에 저장한다.
 * 
 *className InputNumbers
 *version 	1.0.0
 *Date		26/03/2019 
 *author	권경동 
 */
import java.util.Scanner;

public class InputNumbers {
	int[] num = new int[3];		

	public InputNumbers() {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		for(int i = 0 ; i < 3 ; i++) {
			this.num[i] = temp.charAt(i)-48;
		}
	}
}
