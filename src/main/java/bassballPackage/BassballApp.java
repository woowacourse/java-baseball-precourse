package bassballPackage;

import bassballPackage.CpuInput;
import bassballPackage.UserInput;
import bassballPackage.PrintOut;

public class BassballApp {
	static int[] SBCountArr;
	
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
		/*프로그램 구조*/
		boolean isLoopActive = true;
		CpuInput.cpuNumArr = CpuInput.cpuInput();
		while (isLoopActive) {
			System.out.println("[[디버깅용 메세지]]-컴퓨터 세자리 수 : " 
					+ CpuInput.cpuNumArr[0]+","
					+ CpuInput.cpuNumArr[1]+","
					+ CpuInput.cpuNumArr[2]);
			UserInput.userNumArr = UserInput.userInputValid2();
			SBCountArr = SBCount(UserInput.userNumArr, CpuInput.cpuNumArr);
			PrintOut.printOut(SBCountArr);
		}
	}
}
