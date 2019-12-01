package bassballPackage;

public class CpuInput {
	static int[] cpuNumArr;
	
	static int randomGeneration() {		//1~9사이 정수 랜덤생성
		return (int)(Math.random() * 9) + 1;
	}
	
	static int[] cpuInput() {
		int[] result = new int[3];
		result[0] = randomGeneration();
		
		int tmpVal1 = randomGeneration();
		while(tmpVal1 == result[0]) {
			tmpVal1 = randomGeneration();
		}
		result[1] = tmpVal1;
		
		int tmpVal2 = randomGeneration();
		while(tmpVal2 == result[0] || tmpVal2 == result[1] ) {
			tmpVal2 = randomGeneration();
		}
		result[2] = tmpVal2;
		
		return result;
	}
}
