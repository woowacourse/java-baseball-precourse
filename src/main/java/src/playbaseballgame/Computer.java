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
	
}