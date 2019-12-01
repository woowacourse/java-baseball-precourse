package bassballPackage;

public class BassballApp {
	static int[] SBCount(int[] userArr, int[] cpuArr){
		int[] result = {0, 0};
		for(int i = 1; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				result[0] += SCountIf(userArr, cpuArr, i, j);
				result[1] += BCountIf(userArr, cpuArr, i, j);
			}
		}
		return result;
	}
	
	static int SCountIf(int[] userArr, int[] cpuArr, int i, int j) {
		if(i-1 == j && userArr[i] == cpuArr[j]) {
			return 1;
		}else {
			return 0;
		}
	}
	
	static int BCountIf(int[] userArr, int[] cpuArr, int i, int j) {
		if(i-1 != j && userArr[i] == cpuArr[j]) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		//SBCount test
//		int[] user1 = {123,1,2,3};
//		int[] cpu1 = {1,2,3};
//		int[] result1 = SBCount(user1, cpu1);
//		System.out.println(result1[0]);
//		System.out.println(result1[1]);
		
		/**프로그램 구조**/
		boolean isLoopActive = true;
		//cpuInput메서드 호출할 자리.
		while (isLoopActive) {
			//userInputValid2메서드 호출할 자리.
			//SBCount(유저, 컴퓨터); <<<변수이름 미정.
			//printOut(S/B갯수 배열);
		}
	}

}
