/**
 * 이 클래스는 3개의 서로 다른 한자리 자연수를 생성하기 위한 클래스이다.
 * 클래스 생성과 동시에  1~9 사이의 서로 다른 자연수를 생성하여 배열에 저장한다.
 * 
 *className RandomNumbers
 *version 	1.0.0
 *Date		26/03/2019
 *author	권경동 
 */

import java.util.Random;

public class RandomNumbers {
	int[] num = new int[3];
	
	public RandomNumbers() {
		Random random = new Random();
		for(int i = 0 ; i < 3 ;) {
			int temp = random.nextInt(9)+1;
			if((this.num[0] != temp) && (this.num[1] != temp) && (this.num[2] != temp)) {
				this.num[i] = temp;
				i++;
			} else {
				continue;
			}
		}		
	}
}
