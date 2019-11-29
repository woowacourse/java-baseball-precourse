package bassballPackage;

public class BassballApp {
	static int[] SBCount(int[] userArr, int[] cpuArr){
		int[] result = {0, 0};
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == j && userArr[i] == cpuArr[j]) {
					result[0] += 1;
				}else if(userArr[i] == cpuArr[j]) {
					result[1] += 1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] user1 = {1,2,3};
		int[] cpu1 = {1,2,3};
		int[] result1 = SBCount(user1, cpu1);
		System.out.println(result1[0]);
		System.out.println(result1[1]);

	}

}
