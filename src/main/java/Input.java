/**
 * 클래스 이름      Input
 * 버전 정보        1.0
 * 날짜            2019.12.03
 * 저작권          joi0104
 */

import java.util.Scanner;

public class Input{
	int[] inputNum;
	
	public Input() {
		inputNum = new int[3];
	}
	
	/*사용자에게 입력값을 받는 함수*/
	public int[] getInput() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        String str_input = sc.next();
        inputNum[0] = (int)str_input.charAt(0) - 48;
        inputNum[1] = (int)str_input.charAt(1) - 48;
        inputNum[2] = (int)str_input.charAt(2) - 48;
        return inputNum;
    }
	
}