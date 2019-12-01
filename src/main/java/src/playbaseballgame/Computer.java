/*
 * @(#)Computer.java		 2019/12/01
 * 
 * 
 * Copyright (c) YerinCho
 * 
 * 
 */

package playbaseballgame;

/**
 * 
 * @version 0.1 2019년 12월 1일
 * @author YerinCho
 */

class Computer {
	
	private int rand_answer=0;           //랜덤한 세 자리의 수
	
	/*랜덤한 세 자리의 수 만드는 함수*/
	public void makeAnswer() {
		
		int first=0;			//각각 첫번째, 두번째, 세번째 자리 수 
		int second=0;
		int third=0;     
		first=(int)(Math.random()*9)+1;		//첫번째 자리 수 생성
		while (first!=second) {
			
			/*두번째 자리의 수가 첫번째와 겹치지 않기 위한 반복문*/
			second=(int)(Math.random()*9)+1;
		}
		while((third!=second) && (third!=first)) {
			
			/*세번째 자리의 수가 첫번째, 두번째와 겹치지 않기 위한 반복문*/
			third=(int)(Math.random()*9)+1;
		}
		
		this.rand_answer=first*100 + second * 10 + third;
	}
	
	/*스트라이크와 볼의 개수를 확인하고, 출력까지 해주는 함수*/
	public boolean checkStrikeBall(int input) {
		boolean finish;
		
		int s=checkStrike(input);
		int b=checkBall(input);
		
		finish=print(s,b);
		
		return finish;
	}
	
	/*Strike 개수가 몇 개인지 리턴하는 함수*/
	public int checkStrike(int input) {
		
		int strike=0;			//스트라이크의 개수 카운트할 변수
		int tmp_ans=this.rand_answer;
		int tmp_input=input;
		
		/*세번째 자리 수 비교*/
		if ((tmp_ans%10) == (tmp_input%10)) {
			strike++;			//같으면 개수 카운트
		}
		
		/*두번째 자리 수 비교를 위한 값 수정*/
		tmp_ans/=10;
		tmp_input/=10;
		
		/*두번째 자리 수 비교*/
		if((tmp_ans%10)==(tmp_input%10)) {
			strike++;
		}
		
		/*첫번째 자리 수 비교를 위한 값 수정*/
		tmp_ans/=10;
		tmp_input/=10;
		
		/*첫번째 자리 수 비교*/
		if(tmp_ans==tmp_input) {
			strike++;
		}
		
		return strike;
	}
	
	/*볼 개수를 리턴하는 함수*/
	int checkBall(int input) {
		
		int ball=0;			//볼 개수를 카운트할 변수
		int tmpans=this.rand_answer;
		int tmpin=input;
		
		int tmp_ans[] = new int [3];		//정답의 각 자리수를 저장할 배열 선언
		int tmp_input[ ]= new int [3];		//사용자 입력값의 각 자리수를 저장할 배열 선언
		
		
		/*
		 * 정답과 사용자 입력값의 각 자리수를 저장하기 위한 반복문
		 * 세번째 자리부터 저장한다
		 * */
		for (int i=2;i>=0;i--) {
			tmp_ans[i]=tmpans%10;
			tmp_input[i]=tmpin%10;
			
			tmpans/=10;
			tmpin/=10;
		}
		
		/*값은 같지만 자리수는 다른 경우에 ball 카운트*/
		if ((tmp_ans[0]==tmp_input[1]) || (tmp_ans[0]==tmp_input[2])) {
			ball++;
		}
		
		if ((tmp_ans[1]==tmp_input[0]) || (tmp_ans[1]==tmp_input[2])) {
			ball++;
		}
		
		if ((tmp_ans[2]==tmp_input[0]) || (tmp_ans[2]==tmp_input[1])) {
			ball++;
		}
		
		return ball;
	}
}