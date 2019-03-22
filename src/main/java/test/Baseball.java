package test;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//먼저 게임의 흐름을 잡자.
		Scanner sc = new Scanner(System.in);
		int playerNum= 0;
		int play=1;
		int comNum=0;
		boolean isNew = true;
		while(play==1) {
			//
			if(isNew) 
				comNum=genComNum();
			
			System.out.print("숫자를 입력해주세요 : ");
			playerNum=sc.nextInt();
			
			//스트라이크 볼 낫싱 조건 등
			int strikeCnt=0,ballCnt=0;
			chkNum(comNum,playerNum);
			
			if(strikeCnt!=0)
				System.out.print(strikeCnt+" 스트라이크 ");
			if(ballCnt!=0)
				System.out.print(ballCnt+"  볼");
			if(strikeCnt == 0 && ballCnt == 0)
				System.out.print("낫싱");
			System.out.println();
			
			if(strikeCnt!=3) {
				isNew=false;
				continue;
			}
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			play=sc.nextInt();
			if(play==2)
				break;
			isNew=true;
		}
		System.out.println("게임을 종료합니다.");
	}

	private static void chkNum(int comNum, int playerNum) {
		// TODO Auto-generated method stub
		//두 숫자를 비교하고 경우에 따라 스트라이크, 볼 value 증가
	}

	private static int genComNum() {
		// TODO Auto-generated method stub
		//컴퓨터 랜덤숫자 생성 메소드
		return 0;
	}

}
