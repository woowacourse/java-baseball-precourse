/**
 * 클래스 이름       GameRestart
 * 버전 정보        1.0
 * 날짜            2019.12.03
 * 저작권          joi0104
 */

import java.util.Scanner;

public class CheckRestart {
	boolean restart;
	
	CheckRestart(){
		restart = true;
	}
	
	/*사용자에게 진행여부 묻는 함수*/
	public boolean isRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int inputRestart = sc.nextInt();               //사용자에게 진행여부를 묻기
		return restart;
	}

}