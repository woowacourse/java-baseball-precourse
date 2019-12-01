package baseball;

import java.util.Scanner;
import java.util.Random;

public class Baseball {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(true) {
			int[] ans = GenerateThreeRandNum();
			
			System.out.print("숫자를 입력해주세요 : ");
			String str = scan.nextLine();
			
			//제대로 된 입력인지 판별. 아니면 예외처리
			
			int[] input = StringToIntArray(str);
		
		}
	}
	
	
	
	static int[] GenerateThreeRandNum() {
		int ans[] = new int[3];
		Random random = new Random();
		int count = 0;
		while(count < 3) {
			int randomNum = random.nextInt(9)+1;
			if(duplicateCheck(ans, randomNum, count)) {
				continue;
			}else {
				ans[count] = randomNum;
				count++;
			}
		}		
		return ans;
	}
	
	static boolean duplicateCheck(int[] arr, int num, int count) {
		for(int i = 0; i<count; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;	
	}
	
	static int[] StringToIntArray(String str) {
		int ans[] = new int[3];
		for(int i = 0; i<3; i++) {
			ans[i] = str.charAt(i) - '0';
		}
		return ans;
	}
	

}
