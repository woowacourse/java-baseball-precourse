/**
 * @(#)StrikeBall.java
 * 0.0.0
 * 2019/12/03
 * 저작권 및 라이센스
 */

package com.precourse.bassballapp;

/**
 * 사용자 입력과 컴퓨터 답을 대조하여 스트라이크 & 볼의 갯수를 반환하는 기능 담당.
 * @version 0.0.0 2019년 12월 03일
 * @author tiroring
 */
public class StrikeBall {
	/** 반환된 S&B 갯수를 저장하는 변수 */
	static int[] resultArr;
	
	/** 사용자 입력과 컴퓨터 답을 대조하여 스트라이크 & 볼의 갯수를 반환 
	 * @param userArr User.answerArr 배열이 [전체숫자, 백, 십, 일]
	 * 			형식이기 때문에 인덱스 호출시 주의해야 한다.
	 * @param cpuArr Cpu.answerArr
	 * @return 스트라이크와 볼의 갯수를 배열형식으로 반환
	 */
	static int[] count(int[] userArr, int[] cpuArr){
		int[] result = {0, 0};
		for(int i = 1; i < userArr.length; i++) {
			for(int j = 0; j < cpuArr.length; j++) {
				result[0] += existStrike(userArr, cpuArr, i, j);
				result[1] += existBall(userArr, cpuArr, i, j);
			}
		}
		return result;
	}
	
	/** count메서드 내부에서 스트라이크가 있는지를 판별한다 */
	static int existStrike(int[] userArr, int[] cpuArr,
			int i, int j) {
		if(i-1 == j && userArr[i] == cpuArr[j]) {
			return 1;
		}else {
			return 0;
		}
	}
	
	/** count메서드 내부에서 볼이 있는지를 판별한다 */
	static int existBall(int[] userArr, int[] cpuArr, 
			int i, int j) {
		if(i-1 != j && userArr[i] == cpuArr[j]) {
			return 1;
		}else {
			return 0;
		}
	}
}
