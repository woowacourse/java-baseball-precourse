package baseball;

import java.util.Scanner;
import java.util.Random;

public class Baseball {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(true) {
			int[] ans = generateThreeRandNum();
			boolean isEqual = false;
			while(!isEqual) {
				System.out.print("숫자를 입력해주세요 : ");
				String str = scan.nextLine();
				
				//제대로 된 입력인지 판별. 아니면 예외처리
				
				int[] input = stringToIntArray(str);
				isEqual = compareAndPrintResult(ans,input);
			}
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			int replay = scan.nextInt();
			if(replay == 2) {
				break;
			}
		}
	}
	
	
	
	static int[] generateThreeRandNum() {
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
	
	static int[] stringToIntArray(String str) {
		int ans[] = new int[3];
		for(int i = 0; i<3; i++) {
			ans[i] = str.charAt(i) - '0';
		}
		return ans;
	}
	
	static boolean compareAndPrintResult(int[] arr1, int[] arr2) {
		int strikeCount = 0;
		int ballCount = 0;
		if(arr2[0] == arr1[0]) {
			strikeCount++;
		}
		if(arr2[0] == arr1[1]) {
			ballCount++;
		}
		if(arr2[0] == arr1[2]) {
			ballCount++;
		}
		if(arr2[1] == arr1[0]) {
			ballCount++;
		}
		if(arr2[1] == arr1[1]) {
			strikeCount++;
		}
		if(arr2[1] == arr1[2]) {
			ballCount++;
		}
		if(arr2[2] == arr1[0]) {
			ballCount++;
		}
		if(arr2[2] == arr1[1]) {
			ballCount++;
		}
		if(arr2[2] == arr1[2]) {
			strikeCount++;
		}
		
		if(strikeCount != 0) {
			System.out.print(strikeCount+"스트라이크 ");
		}
		if(ballCount != 0) {
			System.out.print(ballCount+"볼");
		}
		System.out.println();
		
		if(strikeCount == 3) {
			return true;
		}else {
			return false;
		}
	}

}
