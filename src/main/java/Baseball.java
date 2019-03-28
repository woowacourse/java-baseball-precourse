/* 
 * 클래스 이름 : Baseball
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/03/28
 * Copyright (c) 2019 Moonyoung Chae
 */

public class Baseball {
	static int NUM_SIZE = 3;
	int[] computerNumbers = new int[NUM_SIZE];	// 컴퓨터 난수
	
	// 컴퓨터 난수를 생성하는 함수
	public void initComputerNumbers() {
		// 초기화
		for(int i = 0; i < NUM_SIZE; i++) {
			computerNumbers[i] = (int)(Math.random() * 10);
		}
		
		// 조건에 맞지 않을 경우, 다시 난수를 생성
		while(true) {
			if(computerNumbers[0] == 0) {
				computerNumbers[0] = (int)(Math.random()*10);
			}else {
				break;
			}
		}

		while(true) {
			if((computerNumbers[1] == 0) || (computerNumbers[1] == computerNumbers[0])) {
				computerNumbers[1] = (int)(Math.random()*10);
			}else {
				break;
			}
		}

		while(true) {
			if((computerNumbers[2] == 0) || (computerNumbers[2] == computerNumbers[0])
					|| (computerNumbers[2] == computerNumbers[1])) {
				computerNumbers[2] = (int)(Math.random()*10);
			}else {
				break;
			}
		}
	}	
}
