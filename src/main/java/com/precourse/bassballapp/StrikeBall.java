package com.precourse.bassballapp;

public class StrikeBall {
	static int[] resultArr;
	
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
	
	static int existStrike(int[] userArr, int[] cpuArr,
			int i, int j) {
		if(i-1 == j && userArr[i] == cpuArr[j]) {
			return 1;
		}else {
			return 0;
		}
	}
	
	static int existBall(int[] userArr, int[] cpuArr, 
			int i, int j) {
		if(i-1 != j && userArr[i] == cpuArr[j]) {
			return 1;
		}else {
			return 0;
		}
	}
}
